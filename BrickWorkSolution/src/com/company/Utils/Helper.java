package com.company.Utils;

import com.company.Exceptions.InvalidBrickInput;
import com.company.Exceptions.InvalidSizeInput;

import java.util.Scanner;

import static java.lang.String.format;

public class Helper {

    private static final Scanner in = new Scanner(System.in);

    public static void validateSizeInput(String[] input) {
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);

        if (columns % 2 != 0 || rows % 2 != 0) {
            throw new InvalidSizeInput("Numbers must be even!");
        }

        if (columns == rows) {
            throw new InvalidSizeInput("Size must be rectangular!");
        }

        if (columns > 100) {
            throw new InvalidSizeInput("Column number must be lower than 100!");
        }
    }

    public static int[][] fillTheBricks(int rows, int columns) {
        int[][] brickWall = new int[rows][columns];
        int validateBrick = 0;

        for (int i = 0; i < rows; i++) {
            String[] matrixFill = in.nextLine().split(" ");
            for (int j = 0; j < columns; j++) {
                if (matrixFill.length < columns) {
                    throw new InvalidSizeInput(format("Please fill the whole %d spaces", rows * columns));
                }

                int currentBrickSquare = Integer.parseInt(matrixFill[j]);

                if (j > 0) {
                    if (j % 2 == 0) {
                        int backBrick = Integer.parseInt(matrixFill[j - 1]);
                        if (currentBrickSquare == backBrick) {
                            throw new InvalidBrickInput("Brick cannot be with size more than two consecutive numbers!");
                        }
                    }
                }

                if (j < columns - 1) {
                    int forwardBrickSquare = Integer.parseInt(matrixFill[j + 1]);

                    if (currentBrickSquare == forwardBrickSquare) {
                        validateBrick++;
                    }

                    if (j % 2 == 0) {
                        if (validateBrick == 0) {
                            throw new InvalidBrickInput("Brick needs to have two equal number squares!");
                        }
                    }
                }
                validateBrick = 0;

                brickWall[i][j] = currentBrickSquare;
            }
        }
        return brickWall;
    }
}