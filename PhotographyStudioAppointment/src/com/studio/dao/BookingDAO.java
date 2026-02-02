package com.studio.dao;

import java.sql.*;
import java.util.*;
import com.studio.bean.Booking;
import com.studio.util.DBUtil;

public class BookingDAO {

    public int generateBookingID() {
        try {
            Connection con = DBUtil.getDBConnection();
            ResultSet rs = con.createStatement()
                    .executeQuery("SELECT booking_seq.NEXTVAL FROM dual");
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean recordBooking(Booking b) {
        try {
            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps =
                con.prepareStatement("INSERT INTO BOOKING_TBL VALUES(?,?,?,?,?,?,?)");

            ps.setInt(1, b.getBookingID());
            ps.setString(2, b.getCustomerID());
            ps.setDate(3, new java.sql.Date(b.getShootDate().getTime()));
            ps.setString(4, b.getStartTime());
            ps.setString(5, b.getEndTime());
            ps.setString(6, b.getPackageType());
            ps.setString(7, b.getStatus());

            boolean result = ps.executeUpdate() > 0;
            con.commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateBookingStatus(int bookingID, String status) {
        try {
            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps =
                con.prepareStatement(
                    "UPDATE BOOKING_TBL SET STATUS=? WHERE BOOKING_ID=?");

            ps.setString(1, status);
            ps.setInt(2, bookingID);

            boolean result = ps.executeUpdate() > 0;
            con.commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateBookingSlot(int bookingID, java.util.Date newDate,
                                     String newStart, String newEnd) {
        try {
            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps =
                con.prepareStatement(
                    "UPDATE BOOKING_TBL SET SHOOT_DATE=?, START_TIME=?, END_TIME=? WHERE BOOKING_ID=?");

            ps.setDate(1, new java.sql.Date(newDate.getTime()));
            ps.setString(2, newStart);
            ps.setString(3, newEnd);
            ps.setInt(4, bookingID);

            boolean result = ps.executeUpdate() > 0;
            con.commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Booking> findBookingsByCustomer(String customerID) {
        List<Booking> list = new ArrayList<>();
        try {
            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps =
                con.prepareStatement(
                    "SELECT * FROM BOOKING_TBL WHERE CUSTOMER_ID=?");

            ps.setString(1, customerID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Booking b = new Booking();
                b.setBookingID(rs.getInt("BOOKING_ID"));
                b.setCustomerID(rs.getString("CUSTOMER_ID"));
                b.setShootDate(rs.getDate("SHOOT_DATE"));
                b.setStartTime(rs.getString("START_TIME"));
                b.setEndTime(rs.getString("END_TIME"));
                b.setPackageType(rs.getString("PACKAGE_TYPE"));
                b.setStatus(rs.getString("STATUS"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Booking> findBookingsForDate(java.util.Date shootDate) {
        List<Booking> list = new ArrayList<>();
        try {
            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps =
                con.prepareStatement(
                    "SELECT * FROM BOOKING_TBL WHERE SHOOT_DATE=?");

            ps.setDate(1, new java.sql.Date(shootDate.getTime()));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Booking b = new Booking();
                b.setBookingID(rs.getInt("BOOKING_ID"));
                b.setCustomerID(rs.getString("CUSTOMER_ID"));
                b.setShootDate(rs.getDate("SHOOT_DATE"));
                b.setStartTime(rs.getString("START_TIME"));
                b.setEndTime(rs.getString("END_TIME"));
                b.setPackageType(rs.getString("PACKAGE_TYPE"));
                b.setStatus(rs.getString("STATUS"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
