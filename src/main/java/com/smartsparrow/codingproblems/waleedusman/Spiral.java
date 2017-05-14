package com.smartsparrow.codingproblems.waleedusman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Spiral {
    private int height;
    private int width;
    private int startingRow;
    private int startingColumn;
    private int[][] grid;

    public Spiral(String constraints) {
        parseInput(constraints);
        grid = new int[height][width];
        init(grid);
    }

    public List<Integer> run() {
        List<Integer> result = new ArrayList<>();
        result.add(grid[startingRow][startingColumn]);

        int traversalDistance = 1;
        int currentRow = startingRow;
        int currentColumn = startingColumn;

        // continue traversing until all points of grid have been visited
        while (result.size() != (height * width)) {
            // go up
            for (int k = 1; k <= traversalDistance; k++) {
                currentRow--;
                if (withinGrid(currentRow, currentColumn) && (!result.contains(grid[currentRow][currentColumn]))) {
                    result.add(grid[currentRow][currentColumn]);
                }
            }
            // go left
            for (int k = 1; k <= traversalDistance; k++) {
                currentColumn--;
                if (withinGrid(currentRow, currentColumn) && (!result.contains(grid[currentRow][currentColumn]))) {
                    result.add(grid[currentRow][currentColumn]);
                }
            }
            traversalDistance++;
            // go down
            for (int k = 1; k <= traversalDistance; k++) {
                currentRow++;
                if (withinGrid(currentRow, currentColumn) && (!result.contains(grid[currentRow][currentColumn]))) {
                    result.add(grid[currentRow][currentColumn]);
                }
            }
            // go right
            for (int k = 1; k <= traversalDistance; k++) {
                currentColumn++;
                if (withinGrid(currentRow, currentColumn) && (!result.contains(grid[currentRow][currentColumn]))) {
                    result.add(grid[currentRow][currentColumn]);
                }
            }
            traversalDistance++;
        }

        return result;
    }

    private boolean withinGrid(int row, int column) {
        return ((row >= 0) && (column >= 0) && (row < height) && (column < width));
    }

    private void parseInput(String input) {
        Scanner parser = new Scanner(input).useDelimiter(" ");
        try {
            height = parser.nextInt();
            width = parser.nextInt();
            startingRow = parser.nextInt() - 1;
            startingColumn = parser.nextInt() - 1;
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid input, must be formatted as 4 integers: H W R C");
        }
        if ((startingRow > height) || (startingColumn > width)) {
            throw new IllegalArgumentException("Invalid input, the row and column must both be within the grid");
        }
    }

    private void init(int[][] matrix) {
        int initialValue = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = ++initialValue;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter grid dimensions (height/width) followed by starting point (row/column): ");
        String input = new Scanner(System.in).nextLine();

        new Spiral(input).run().stream().forEachOrdered(i -> System.out.print(i + " "));
    }
}
