package day05;

import java.util.List;

public class SeatIDCalculator {
    public double calculate(String seatCode) {
        String rowCode = seatCode.substring(0, 7);
        String columnCode = seatCode.substring(7, 10);

        List<String> rowCodeCharacters = List.of(rowCode.split(""));
        double rowNumber = 0;
        for (int i = 0; i < rowCodeCharacters.size(); i++) {
            if (rowCodeCharacters.get(i).equals("B")) {
                rowNumber = rowNumber + 128 / (Math.pow(2, i + 1));
            }
        }

        List<String> columnCodeCharacters = List.of(columnCode.split(""));
        double columnNumber = 0;
        for (int i = 0; i < columnCodeCharacters.size(); i++) {
            if (columnCodeCharacters.get(i).equals("R")) {
                columnNumber = columnNumber + 8 / (Math.pow(2, i + 1));
            }
        }
        //System.out.println(rowNumber);
        //System.out.println(columnNumber);

        return rowNumber * 8 + columnNumber;

    }
}
