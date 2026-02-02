package com.studio.util;

public class ValidationException extends Exception {
    public String toString() {
        return "Validation failed due to invalid input";
    }
}
