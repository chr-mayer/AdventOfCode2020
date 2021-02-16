package day03;

import FileReader.FileReader;

import java.util.List;

public class TreeCounter {
    private final String pathString = "src/day03/input.txt";
    private final FileReader fileReader = new FileReader();
    List<String> lines = fileReader.read(pathString);
    int lineLength = lines.get(0).length();

    public long count(int slopeX, int slopeY) {
        int numberOfTrees = 0;
        for (int lineNumber = 0; lineNumber < lines.size(); lineNumber++) {

            if ((lineNumber % slopeY) == 0) {
                int position = (lineNumber / slopeY * slopeX) % lineLength;
                if (lines.get(lineNumber).charAt(position) == '#') {
                    numberOfTrees++;
                }
            }
        }
        return numberOfTrees;
    }


}
