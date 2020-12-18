package com.company;

import java.util.Scanner;

import static com.company.Utils.Helper.fillTheBricks;
import static com.company.Utils.Helper.validateSizeInput;


public class Start {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        String[] input = in.nextLine().split(" ");
        validateSizeInput(input);

        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);

        int[][] brickWall = fillTheBricks(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(brickWall[i][j]);
            }
        }
    }
}