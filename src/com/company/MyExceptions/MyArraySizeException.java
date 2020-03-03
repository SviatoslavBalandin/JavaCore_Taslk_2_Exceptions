package com.company.MyExceptions;

public class MyArraySizeException extends Exception {

    private int wrongSize;

    public MyArraySizeException(int size) {
        this.wrongSize = size;
    }
    public String getMessage() {
        return "Wrong size! - " + wrongSize;
    }
}
