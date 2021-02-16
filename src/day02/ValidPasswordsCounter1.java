package day02;

import FileReader.FileReader;

import java.util.List;

public class ValidPasswordsCounter1 {
    String pathString = "src/aoc/day02/input.txt";

    public int count() {
        LineParser1 lineParser1 = new LineParser1();
        FileReader fileReader = new FileReader();
        List<String> lines = fileReader.read(pathString);
        int counter = 0;
        for (String line : lines) {
            if (lineParser1.parse(line)) {
                counter++;
            }
        }
        return counter;

    }


}
