package day17;


import FileReader.FileReader;

import java.util.ArrayList;
import java.util.List;

public class Cubes3dim {
    private String pathString = "src/day17/input.txt";
    private FileReader fileReader = new FileReader();
    private int addSpace = 6;
    private boolean[][][] grid = createStartGrid();



    public boolean[][] readInput() {
        List<String> lines = fileReader.read(pathString);
        List<List<String>> inputStrings = new ArrayList<>();
        for (String line:lines) {
            String[] splitted = line.split("");
            inputStrings.add(List.of(splitted));
        }
        int size = inputStrings.size();
        boolean[][] input = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (inputStrings.get(i).get(j).equals(".")) input[i][j] = false;
                else input[i][j] = true;
            }
        }
        return input;
    }


    public boolean[][][] createStartGrid() {
        boolean[][] input = readInput();
        int length = input.length + 2* addSpace;
        int zLength = 1 + 2* addSpace;
        boolean[][][] startGrid = new boolean[length][length][zLength];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                startGrid[addSpace +i][addSpace +j][addSpace] = input[i][j];
            }
        }
        return startGrid;
    }



    public boolean hasExactly2or3ActiveNeighbours(boolean[][][] grid, int x, int y, int z) {
        int xLength = grid.length;
        int yLength = grid[0].length;
        int zLength = grid[0][0].length;
        int count = 0;
        for (int i = -1; i < 2; i++) {
            if (x+i < 0 || x+i >= xLength) continue;
            for (int j = -1; j < 2; j++) {
                if (y+j < 0 || y+j >= yLength) continue;
                for (int k = -1; k < 2; k++) {
                    if (z+k < 0 || z+k >= zLength) continue;
                    if (x+i==x && y+j==y && z+k==z) continue;
                    if (grid[x+i][y+j][z+k]) count++;
                }
            }
        }
        if (count == 2 || count == 3) return true;
        return false;
    }



    public boolean hasExactly3ActiveNeighbours(boolean[][][] grid, int x, int y, int z) {
        int xLength = grid.length;
        int yLength = grid[0].length;
        int zLength = grid[0][0].length;
        int count = 0;
        for (int i = -1; i < 2; i++) {
            if (x+i < 0 || x+i >= xLength) continue;
            for (int j = -1; j < 2; j++) {
                if (y+j < 0 || y+j >= yLength) continue;
                for (int k = -1; k < 2; k++) {
                    if (z+k < 0 || z+k >= zLength) continue;
                    if (x+i==x && y+j==y && z+k==z) continue;
                    if (grid[x+i][y+j][z+k]) count++;
                }
            }
        }
        if (count == 3) return true;
        return false;
    }


    public boolean[][][] simulateOneCycle(boolean[][][] input) {
        int xLength = input.length;
        int yLength = input[0].length;
        int zLength = input[0][0].length;
        boolean[][][] output = new boolean[xLength][yLength][zLength];

        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                for (int k = 0; k < zLength; k++) {
                    if (input[i][j][k]) {
                        if (hasExactly2or3ActiveNeighbours(input,i,j,k)) {
                            output[i][j][k] = true;
                        } else {
                            output[i][j][k] = false;
                        }
                    } else {
                        if (hasExactly3ActiveNeighbours(input,i,j,k)) {
                            output[i][j][k] = true;
                        } else {
                            output[i][j][k] = false;
                        }
                    }
                }
            }
        }
        return output;
    }




    public boolean[][][] simulateSixCycleBootProcess() {
        boolean[][][] start = this.grid;
        boolean[][][] input = simulateOneCycle(start);
        for (int i = 0; i < 5; i++) {
            input = simulateOneCycle(input);
        }
        return input;
    }




    public int countActiveCells(boolean[][][] grid) {
        int xLength = grid.length;
        int yLength = grid[0].length;
        int zLength = grid[0][0].length;
        int count = 0;
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                for (int k = 0; k < zLength; k++) {
                    if (grid[i][j][k]) count++;
                }
            }
        }
        return count;
    }


    public void printPlane(int z) {
        int xLength = grid.length;
        int yLength = grid[0].length;

        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (grid[i][j][z]) System.out.print("#");
                else System.out.print(".");
            }
            System.out.println();
        }
    }





























}
