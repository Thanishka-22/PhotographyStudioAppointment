package com.studio.util;

public class ActiveBookingException extends Exception {
    public String toString() {
        return "Customer has active bookings and cannot be removed";
    }
}
