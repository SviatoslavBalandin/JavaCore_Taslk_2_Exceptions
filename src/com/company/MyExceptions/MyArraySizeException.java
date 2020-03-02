package com.company.MyExceptions;

public class MyArraySizeException extends RuntimeException {

    private int wrongSize;

    public MyArraySizeException(int size) {
        this.wrongSize = size;
    }
    public int getWrongSize() {
        return wrongSize;
    }
}
