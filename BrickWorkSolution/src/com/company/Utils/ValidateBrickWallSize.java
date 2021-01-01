package com.company.Utils;

import com.company.Exceptions.InvalidSizeInput;

public class ValidateBrickWallSize {

    private static final String NUMBERS_NOT_EVEN_ERROR = "Numbers must be even!";
    private static final String SIZE_NOT_RECTANGULAR_ERROR = "Size must be rectangular!";
    private static final String LINES_AND_ROWS_NOT_VALID_ERROR = "Column or Row number must be lower than 100!";

    public static void validateSizeInput(String[] input) {
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);

        if (columns % 2 != 0 || rows % 2 != 0) {
            throw new InvalidSizeInput(NUMBERS_NOT_EVEN_ERROR);
        }

        if (columns == rows) {
            throw new InvalidSizeInput(SIZE_NOT_RECTANGULAR_ERROR);
        }

        if (columns > 100 || rows > 100) {
            throw new InvalidSizeInput(LINES_AND_ROWS_NOT_VALID_ERROR);
        }
    }
}