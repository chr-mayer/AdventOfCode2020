package day11;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeatChooser {
    private String pathString = "src/day11/input.txt";
    private FileReader fileReader = new FileReader();

    public Boolean[][] getInput() {
        List<String> lineStrings = fileReader.read(pathString);
        int numberOfColumns = lineStrings.get(0).length();
        int numberOfRows = lineStrings.size();
        List<Boolean[]> lines = new ArrayList<>();
        for (String line : lineStrings) {
            String[] splittedLine = line.split("");
            Boolean[] row = new Boolean[numberOfColumns];
            for (int i = 0; i < numberOfColumns; i++) {
                switch (splittedLine[i]) {
                    case "L":
                        row[i] = Boolean.FALSE;
                        break;
                    case "#":
                        row[i] = Boolean.TRUE;
                        break;
                    default:
                        row[i] = null;
                        break;
                }
            }
            lines.add(row);
        }
        Boolean[][] inputArray = new Boolean[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            inputArray[i] = lines.get(i);
        }
        return inputArray;
    }


    public void print(Boolean[][] array) {
        for (Boolean[] row : array) {
            for (Boolean col : row) {
                String letter = "";
                if (col == null) {
                    letter = ".";
                } else if (col == Boolean.TRUE) {
                    letter = "#";
                } else if (col == Boolean.FALSE) {
                    letter = "L";
                }
                System.out.print(letter);
            }
            System.out.println();
        }
    }


    public int getOccupiedSeats(Boolean[][] array) {
        int count = 0;
        for (Boolean[] row : array) {
            for (Boolean col : row) {
                if (col == null) continue;
                else if (col == Boolean.TRUE) count++;
            }
        }
        return count;
    }


    public int getNumberOfAdjacentOccupiedSeats1(int row, int col, Boolean[][] array) {
        int numberOfRows = array.length;
        int numberOfColumns = array[0].length;
        int numberOfAdjacentOccupiedSeats = 0;
        for (int rowInc = -1; rowInc <= 1; rowInc++) {
            for (int colInc = -1; colInc <= 1; colInc++) {
                if (rowInc == 0 && colInc == 0) continue;
                int row1 = row + rowInc;
                int col1 = col + colInc;
                if (row1 < 0 || row1 >= numberOfRows) continue;
                if (col1 < 0 || col1 >= numberOfColumns) continue;
                Boolean value = array[row1][col1];
                if (value == null) continue;
                if (value.equals(Boolean.TRUE)) numberOfAdjacentOccupiedSeats++;
            }
        }
        return numberOfAdjacentOccupiedSeats;
    }


    public int getNumberOfAdjacentOccupiedSeats2(int row, int col, Boolean[][] array) {
        int numberOfRows = array.length;
        int numberOfColumns = array[0].length;
        int numberOfAdjacentOccupiedSeats = 0;
        for (int rowInc = -1; rowInc <= 1; rowInc++) {
            for (int colInc = -1; colInc <= 1; colInc++) {
                if (rowInc == 0 && colInc == 0) continue;
                int row1 = row + rowInc;
                int col1 = col + colInc;
                if (row1 < 0 || row1 >= numberOfRows) continue;
                if (col1 < 0 || col1 >= numberOfColumns) continue;
                Boolean value1 = array[row1][col1];
                if (value1 != null && value1.equals(Boolean.FALSE)) continue;
                if (value1 != null && value1.equals(Boolean.TRUE)) {
                    numberOfAdjacentOccupiedSeats++;
                    continue;
                }

                while (true) {
                    row1 = row1 + rowInc;
                    col1 = col1 + colInc;
                    if (row1 < 0 || row1 >= numberOfRows) break;
                    if (col1 < 0 || col1 >= numberOfColumns) break;
                    value1 = array[row1][col1];
                    if (value1 != null && value1.equals(Boolean.FALSE)) break;
                    if (value1 != null && value1.equals(Boolean.TRUE)) {
                        numberOfAdjacentOccupiedSeats++;
                        break;
                    }

                }


            }
        }
        return numberOfAdjacentOccupiedSeats;
    }


    public Boolean[][] applyRuleSet1(Boolean[][] array) {
        int numberOfRows = array.length;
        int numberOfColumns = array[0].length;
        Boolean[][] result = new Boolean[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {

                if (array[i][j] == null) {
                    result[i][j] = array[i][j];
                } else if (array[i][j].equals(Boolean.FALSE)) {
                    if (getNumberOfAdjacentOccupiedSeats1(i, j, array) == 0) {
                        result[i][j] = Boolean.TRUE;
                    } else result[i][j] = Boolean.FALSE;
                } else if (array[i][j].equals(Boolean.TRUE)) {
                    if (getNumberOfAdjacentOccupiedSeats1(i, j, array) >= 4) {
                        result[i][j] = Boolean.FALSE;
                    } else result[i][j] = Boolean.TRUE;
                }

            }
        }
        return result;
    }


    public Boolean[][] applyRuleSet2(Boolean[][] array) {
        int numberOfRows = array.length;
        int numberOfColumns = array[0].length;
        Boolean[][] result = new Boolean[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {

                if (array[i][j] == null) {
                    result[i][j] = array[i][j];
                } else if (array[i][j].equals(Boolean.FALSE)) {
                    if (getNumberOfAdjacentOccupiedSeats2(i, j, array) == 0) {
                        result[i][j] = Boolean.TRUE;
                    } else result[i][j] = Boolean.FALSE;
                } else if (array[i][j].equals(Boolean.TRUE)) {
                    if (getNumberOfAdjacentOccupiedSeats2(i, j, array) >= 5) {
                        result[i][j] = Boolean.FALSE;
                    } else result[i][j] = Boolean.TRUE;
                }

            }
        }
        return result;
    }


    public int getAnswerPart1() {
        Boolean[][] array0 = getInput();
/*        print(array0);
        System.out.println("------------------");
        System.out.println();*/
        int count = 0;

        while (true) {
            Boolean[][] array1 = applyRuleSet1(array0);
            //print(array1);
            count++;
            /*System.out.println("count=" + count);
            System.out.println();*/
            if (Arrays.deepEquals(array1, array0)) {
                //System.out.println("count: " + count);
                return getOccupiedSeats(array0);
            }
            array0 = array1;
        }
    }


    public int getAnswerPart2() {
        Boolean[][] array0 = getInput();
        //print(array0);
/*        System.out.println("------------------");
        System.out.println();*/
        int count = 0;

        while (true) {
            Boolean[][] array1 = applyRuleSet2(array0);
            //print(array1);
            count++;
/*            System.out.println("count=" + count);
            System.out.println();*/
            if (Arrays.deepEquals(array1, array0)) {
                //System.out.println("count: " + count);
                return getOccupiedSeats(array0);
            }
            array0 = array1;
        }
    }


}

























