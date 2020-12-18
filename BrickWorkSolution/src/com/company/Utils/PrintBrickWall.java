package com.company.Utils;

public class PrintBrickWall {

    public static void printBrickWall(int rows, int columns, int[][] brickWallReinforced) {
        for (int i = 0; i < rows; i++) {
            System.out.println();
            for (int j = 0; j < columns; j++) {
                if (j < columns - 1) {
                    System.out.print(brickWallReinforced[i][j] + " ");
                } else {
                    System.out.print(brickWallReinforced[i][j]);
                }
            }
        }
    }
}