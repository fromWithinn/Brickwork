package com.company.Utils;

import com.company.Exceptions.InvalidSizeInput;

public class ValidateBrickWallSize {


    public static void validateSizeInput(String[] input) {
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);

        if (columns % 2 != 0 || rows % 2 != 0) {
            throw new InvalidSizeInput("Numbers must be even!");
        }

        if (columns == rows) {
            throw new InvalidSizeInput("Size must be rectangular!");
        }

        if (columns > 100 || rows > 100) {
            throw new InvalidSizeInput("Column or Row number must be lower than 100!");
        }
    }
}