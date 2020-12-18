package com.company.Utils;

import com.company.Exceptions.InvalidBrickInput;
import com.company.Exceptions.InvalidSizeInput;

import java.util.Scanner;

import static java.lang.String.format;

public class FillTheBrickWall {

    private static final Scanner in = new Scanner(System.in);

    public static int[][] fillTheBricks(int rows, int columns) {
        int[][] brickWall = new int[rows][columns];
        int validateBrick = 0;

        for (int i = 0; i < rows; i++) {
            String[] matrixFill = in.nextLine().split(" ");
            for (int j = 0; j < columns; j++) {

                if (matrixFill.length < columns) {
                    throw new InvalidSizeInput(format("Please fill the whole %d spaces", rows * columns));
                }

                boolean isJOnEvenIndex = j % 2 == 0;

                int currentBrickSquare = Integer.parseInt(matrixFill[j]);

                if (j > 0) {
                    if (isJOnEvenIndex) {
                        int backBrick = Integer.parseInt(matrixFill[j - 1]);
                        if (currentBrickSquare == backBrick) {
                            throw new InvalidBrickInput("Brick cannot be with size more than two square numbers!");
                        }
                    }
                }

                if (j < columns - 1) {
                    int forwardBrickSquare = Integer.parseInt(matrixFill[j + 1]);

                    if (currentBrickSquare == forwardBrickSquare) {
                        validateBrick++;
                    }

                    if (isJOnEvenIndex) {
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
