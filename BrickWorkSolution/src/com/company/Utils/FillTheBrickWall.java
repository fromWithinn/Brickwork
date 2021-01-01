package com.company.Utils;

import com.company.Exceptions.InvalidBrickInput;
import com.company.Exceptions.InvalidSizeInput;

import java.util.Scanner;

import static java.lang.String.format;

public class FillTheBrickWall {

    private static final String BRICK_WALL_NOT_FILLED_ERROR = "Please fill the whole %d spaces";
    private static final String BRICK_SIZE_LESS_THAN_TWO_ERROR = "Brick needs to have two equal number squares!";
    private static final String BRICK_SIZE_MORE_THAN_TWO_ERROR = "Brick cannot be with size more than two square numbers!";

    private static final Scanner in = new Scanner(System.in);

    public static int[][] fillTheBricks(int rows, int columns) {
        int[][] brickWall = new int[rows][columns];
        int validateBrick = 0;

        for (int i = 0; i < rows; i++) {
            String[] matrixFill = in.nextLine().split(" ");
            for (int j = 0; j < columns; j++) {

                brickFillValidation(rows, columns, matrixFill);

                boolean isJOnEvenIndex = j % 2 == 0;

                int currentBrickSquare = Integer.parseInt(matrixFill[j]);

                if (j > 0) {
                    moreThanTwoEqualSquaresValidation(matrixFill, j, isJOnEvenIndex, currentBrickSquare);
                }

                if (j < columns - 1) {
                    int forwardBrickSquare = Integer.parseInt(matrixFill[j + 1]);

                    lessThanTwoEqualSquaresValidation(validateBrick, isJOnEvenIndex, currentBrickSquare, forwardBrickSquare);
                }
                validateBrick = 0;

                brickWall[i][j] = currentBrickSquare;
            }
        }
        return brickWall;
    }

    private static void brickFillValidation(int rows, int columns, String[] matrixFill) {
        if (matrixFill.length < columns) {
            throw new InvalidSizeInput(format(BRICK_WALL_NOT_FILLED_ERROR, rows * columns));
        }
    }

    private static void moreThanTwoEqualSquaresValidation(String[] matrixFill, int j, boolean isJOnEvenIndex, int currentBrickSquare) {
        if (isJOnEvenIndex) {
            int backBrick = Integer.parseInt(matrixFill[j - 1]);
            if (currentBrickSquare == backBrick) {
                throw new InvalidBrickInput(BRICK_SIZE_MORE_THAN_TWO_ERROR);
            }
        }
    }

    private static void lessThanTwoEqualSquaresValidation(int validateBrick, boolean isJOnEvenIndex, int currentBrickSquare, int forwardBrickSquare) {
        if (currentBrickSquare == forwardBrickSquare) {
            validateBrick++;
        }

        if (isJOnEvenIndex) {
            if (validateBrick == 0) {
                throw new InvalidBrickInput(BRICK_SIZE_LESS_THAN_TWO_ERROR);
            }
        }
    }
}