package com.studio.service;

import java.util.Date;
import java.util.List;

import com.studio.bean.Booking;
import com.studio.bean.Customer;
import com.studio.dao.BookingDAO;
import com.studio.dao.CustomerDAO;
import com.studio.util.ActiveBookingException;
import com.studio.util.SlotAlreadyBookedException;
import com.studio.util.ValidationException;

public class BookingService {

    private CustomerDAO customerDAO = new CustomerDAO();
    private BookingDAO bookingDAO = new BookingDAO();
    public Customer viewCustomerDetails(String customerID)
            throws ValidationException {

        if (customerID == null || customerID.trim().isEmpty())
            throw new ValidationException();

        return customerDAO.findCustomer(customerID);
    }
    public List<Customer> viewAllCustomers() {
        return customerDAO.viewAllCustomers();
    }
    public boolean addNewCustomer(Customer c)
            throws ValidationException {

        if (c == null ||
            c.getCustomerID() == null ||
            c.getFullName() == null ||
            c.getMobile() == null)
            throw new ValidationException();

        if (customerDAO.findCustomer(c.getCustomerID()) != null)
            return false;

        return customerDAO.insertCustomer(c);
    }
    public boolean createBooking(String customerID, Date shootDate,
                                 String startTime, String endTime,
                                 String packageType)
            throws ValidationException, SlotAlreadyBookedException {
        if (customerID == null || shootDate == null ||
            startTime == null || endTime == null ||
            startTime.compareTo(endTime) >= 0)
            throw new ValidationException();
        if (customerDAO.findCustomer(customerID) == null)
            return false;
        for (Booking b : bookingDAO.findBookingsForDate(shootDate)) {

            if ((b.getStatus().equals("BOOKED")
              || b.getStatus().equals("RESCHEDULED"))
              && startTime.compareTo(b.getEndTime()) < 0
              && endTime.compareTo(b.getStartTime()) > 0) {
                throw new SlotAlreadyBookedException();
            }
        }
        Booking booking = new Booking();
        booking.setBookingID(bookingDAO.generateBookingID());
        booking.setCustomerID(customerID);
        booking.setShootDate(shootDate);
        booking.setStartTime(startTime);
        booking.setEndTime(endTime);
        booking.setPackageType(packageType);
        booking.setStatus("BOOKED");
        return bookingDAO.recordBooking(booking);
    }
    public boolean rescheduleBooking(int bookingID, Date newDate,
                                     String newStart, String newEnd)
            throws ValidationException, SlotAlreadyBookedException {

        if (bookingID <= 0 || newDate == null ||
            newStart == null || newEnd == null ||
            newStart.compareTo(newEnd) >= 0)
            throw new ValidationException();
        for (Booking b : bookingDAO.findBookingsForDate(newDate)) {
            if (b.getBookingID() == bookingID)
                continue;

            if ((b.getStatus().equals("BOOKED")
              || b.getStatus().equals("RESCHEDULED"))
              && newStart.compareTo(b.getEndTime()) < 0
              && newEnd.compareTo(b.getStartTime()) > 0) {

                throw new SlotAlreadyBookedException();
            }
        }

        boolean updated = bookingDAO.updateBookingSlot(
                bookingID, newDate, newStart, newEnd);

        if (updated) {
            bookingDAO.updateBookingStatus(
                    bookingID, "RESCHEDULED");
            return true;
        }
        return false;
    }

    public boolean cancelBooking(int bookingID)
            throws ValidationException {

        if (bookingID <= 0)
            throw new ValidationException();

        return bookingDAO.updateBookingStatus(
                bookingID, "CANCELLED");
    }
    public boolean removeCustomer(String customerID)
            throws ValidationException, ActiveBookingException {

        if (customerID == null || customerID.trim().isEmpty())
            throw new ValidationException();

        List<Booking> list =
                bookingDAO.findBookingsByCustomer(customerID);

        for (Booking b : list) {
            if (b.getStatus().equals("BOOKED")
             || b.getStatus().equals("RESCHEDULED")) {
                throw new ActiveBookingException();
            }
        }
        return customerDAO.deleteCustomer(customerID);
    }
}
