package day04;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private final String pathString = "src/day04/input.txt";
    private final FileReader fileReader = new FileReader();

    public int read() {
        List<String> lines = fileReader.read(pathString);
        List<String> lines2 = new ArrayList<>();
        lines2.add(lines.get(0));
        for (int i = 1; i < lines.size(); i++) {
            if (!lines.get(i).isEmpty()) {
                int len2 = lines2.size();
                lines2.set(len2 - 1, lines2.get(len2 - 1).concat(" ").concat(lines.get(i)));
            } else {
                lines2.add("");
            }
        }

        for (int i = 0; i < lines2.size(); i++) {
            lines2.set(i, lines2.get(i).trim());
        }

        int count = 0;
        for (String line : lines2) {
            if (
                    line.contains("byr:") &&
                            line.contains("iyr:") &&
                            line.contains("eyr:") &&
                            line.contains("hgt:") &&
                            line.contains("hcl:") &&
                            line.contains("ecl:") &&
                            line.contains("pid:")

            ) {
                count++;
            }
        }


        return count;

    }


}
