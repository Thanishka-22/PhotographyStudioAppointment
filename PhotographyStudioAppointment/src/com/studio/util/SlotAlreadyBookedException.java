package com.studio.util;

public class SlotAlreadyBookedException extends Exception {
    public String toString() {
        return "Requested time slot is already booked";
    }
}
