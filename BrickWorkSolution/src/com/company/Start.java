package com.company;

import java.util.List;
import java.util.Scanner;

import static com.company.Utils.BrickToList.getEvenBricks;
import static com.company.Utils.BrickToList.getOddBricks;
import static com.company.Utils.FillTheBrickWall.fillTheBricks;
import static com.company.Utils.ListToReinforcedWall.putEvenBricks;
import static com.company.Utils.ListToReinforcedWall.putOddBricks;
import static com.company.Utils.PrintBrickWall.printBrickWall;
import static com.company.Utils.ValidateBrickWallSize.validateSizeInput;


public class Start {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        String[] input = in.nextLine().split(" ");
        validateSizeInput(input);

        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);

        int[][] brickWall = fillTheBricks(rows, columns);

        List<Integer> evenBricks = getEvenBricks(brickWall);
        List<Integer> oddBricks = getOddBricks(brickWall);

        int[][] brickWallReinforced = new int[rows][columns];
        putEvenBricks(evenBricks, brickWallReinforced);
        putOddBricks(oddBricks, brickWallReinforced);

        printBrickWall(rows, columns, brickWallReinforced);
    }
}