package com.company.MyExceptions;

public class MyArrayDataException extends NumberFormatException {

    private String defectArgument;
    private int coordinateA, coordinateB;

    public MyArrayDataException(String s, int coordinateA, int coordinateB) {
        this.defectArgument = s;
        this.coordinateA = coordinateA;
        this.coordinateB = coordinateB;
    }
    public String getMessage () {
        return "Cast element exception!" + "\n" +  "Details: " + "\n" + "Coordinates: [" + coordinateA + "] [" + coordinateB + "]" + "\n" + "Wrong item - " + defectArgument;
    }

}
