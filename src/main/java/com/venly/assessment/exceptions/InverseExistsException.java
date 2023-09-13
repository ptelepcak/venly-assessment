package com.venly.assessment.exceptions;

public class InverseExistsException extends Exception {
    public InverseExistsException() {
        super("Inverse word combination already exists");
    }
}
