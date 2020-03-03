package com.company;

import com.company.MyExceptions.MyArrayDataException;
import com.company.MyExceptions.MyArraySizeException;

import java.util.Arrays;

public class Main {

    private static int BASIC_FOUR = 4;
    public static void main(String[] args) {

        String[][] correctMatrix = getFilledMatrix();
        String[][] wrongTypeInsideOfMatrix = getFilledMatrix();
        wrongTypeInsideOfMatrix[2][0] = "Sviat";
        String[][] wrongSizeMatrix = new String[2][5];
        String[][] wrongSizeInsideMatrix = new String[4][5];
/*Попеременно затирая комментами использования метода на указанных массивах мы проводим тестирование  */
        try {
            //getSumOf_4_on_4_Matrix(wrongSizeMatrix);
            //getSumOf_4_on_4_Matrix(wrongSizeInsideMatrix);
            getSumOf_4_on_4_Matrix(wrongTypeInsideOfMatrix);
            getSumOf_4_on_4_Matrix(correctMatrix);
        }catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch(MyArrayDataException e) {
            System.out.println(e.getMessage());
        }



    }
    private static void getSumOf_4_on_4_Matrix (String[][] matrix) throws MyArraySizeException {
        int sum = 0;
        /*переменная averageSizeOfInsideMatrix получает значение от метода checkSizeOfInsideMatrix*/
        int averageSizeOfInsideMatrix = checkSizeOfInsideMatrix(matrix);

        if(averageSizeOfInsideMatrix != BASIC_FOUR) {
           throw new MyArraySizeException(averageSizeOfInsideMatrix);
        } else {

            for (int i = 0; i < BASIC_FOUR; i++) {
                for (int j = 0; j < BASIC_FOUR; j++) {
                    try {
                        sum += Integer.parseInt(matrix[i][j]);
                    }catch (NumberFormatException e) {
                        throw new MyArrayDataException(matrix[i][j], i, j);
                    }
                }
            }
        }
        System.out.println("Success! Total sum of matrix is " + sum);
    }
    private static String[][] getFilledMatrix () {
        String[][] matrix = new String[BASIC_FOUR][BASIC_FOUR];
        for (int i = 0; i < BASIC_FOUR; i++) {
            for (int j = 0; j < BASIC_FOUR; j++) {
                matrix[i][j] = String.valueOf(i + 1);
            }
        }
        return matrix;
    }
    private static int checkSizeOfInsideMatrix (String[][] matrix) {

       /* во избежание многократного использования оператора return ввел переменную result  */
        int result = BASIC_FOUR;

        if (matrix.length == BASIC_FOUR) {
            for (int i = 0; i < BASIC_FOUR; i++) {
                if (matrix[i].length != BASIC_FOUR) {
                    result = matrix[i].length;
                    break;
                }
            }
        }
        else {
            result = matrix.length;
        }

        return result;
    }
}
