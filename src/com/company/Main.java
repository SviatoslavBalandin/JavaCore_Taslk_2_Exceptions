package com.company;

import com.company.MyExceptions.MyArrayDataException;
import com.company.MyExceptions.MyArraySizeException;

public class Main {

    private static int BASIC_FOUR = 4;
    public static void main(String[] args) {

        String[][] wrongSizeMatrix = new String[2][5];
        String[][] wrongSizeInsideMatrix = new String[4][5];
        String[][] wrongTypeInsideOfMatrix = new String[BASIC_FOUR][BASIC_FOUR];
        wrongTypeInsideOfMatrix[1][0] = "24";
        wrongTypeInsideOfMatrix[3][3] = "S";
        String[][] correctMatrix = new String[BASIC_FOUR][BASIC_FOUR];
        fillMatrix(correctMatrix);



    }
    private static void getSumOf_4_on_4_Matrix (String[][] matrix) throws MyArraySizeException {
        int sum = 0;
        if(!checkSizeOfInsideMatrix(matrix)) {
           throw new MyArraySizeException(matrix.length);
        } else {

            for (int i = 0; i < BASIC_FOUR; i++) {
                for (int j = 0; j < BASIC_FOUR; j++) {
                    try {
                        sum += Integer.getInteger(matrix[i][j]);
                    }catch (MyArrayDataException e) {
                        System.err.println("Cast element exception! Details: " + "\n" + "Coordinates: [" + i + "] [" + j + "]" + "\n" + "Wrong item - " + matrix[i][j]);
                    }
                }
            }
        }
        System.out.println("Success! Total sum of matrix is " + sum);
    }
    private static void fillMatrix (String[][] matrix) {
        for (int i = 0; i < BASIC_FOUR; i++) {
            for (int j = 0; j < BASIC_FOUR; j++) {
                matrix[i][j] = String.valueOf(i + 1);
            }
        }
    }
    private static boolean checkSizeOfInsideMatrix (String[][] matrix) {
        boolean result = true;

        if (matrix.length != BASIC_FOUR) {
            for (int i = 0; i < BASIC_FOUR; i++) {
                if (matrix[i].length != BASIC_FOUR)
                    result = false;
            }
        }
        else {
            result = false;
        }

        return result;
    }
}
