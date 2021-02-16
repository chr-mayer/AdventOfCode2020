package day02;

import FileReader.FileReader;

import java.util.List;

public class ValidPasswordsCounter2 {
    String pathString = "src/aoc/day02/input.txt";

    public int count() {
        LineParser2 lineParser2 = new LineParser2();
        FileReader fileReader = new FileReader();
        List<String> lines = fileReader.read(pathString);
        int counter = 0;
        for (String line : lines) {
            if (lineParser2.parse(line)) {
                counter++;
            }
        }
        return counter;

    }


}
