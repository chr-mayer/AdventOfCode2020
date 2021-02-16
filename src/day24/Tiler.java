package day24;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Tiler {
    private String pathString = "src/day24/sample_input.txt";
    private FileReader fileReader = new FileReader();
    private Map<String, int[]> directionsToCoordinates = Map.of(
            "e", new int[]{2, 0},
            "ne", new int[]{1, 1},
            "nw", new int[]{-1, 1},
            "w", new int[]{-2, 0},
            "sw", new int[]{-1, -1},
            "se", new int[]{1, -1}

    );

    public void setPathString(String pathString) {
        this.pathString = pathString;
    }

    public Map<String, int[]> getDirectionsToCoordinates() {
        return directionsToCoordinates;
    }

    public List<List<String>> readInstructions() {
        List<List<String>> instructions = new ArrayList<>();
        List<String> lines = fileReader.read(pathString);
        for (String line:lines) {
            List<String> directions = parseLine(line);
            instructions.add(directions);
        }
        return instructions;
    }

    private List<String> parseLine(String line) {
        return List.of(line
                .replaceAll("e", "e ")
                .replaceAll("w", "w ")
                .replaceAll(" +", " ")
                .trim()
                .split(" "));
    }

    public int[] getCoordinate(List<String> instruction) {
        int[] coordinate = {0, 0};
        for (String direction:instruction) {
            coordinate[0] = coordinate[0] + directionsToCoordinates.get(direction)[0];
            coordinate[1] = coordinate[1] + directionsToCoordinates.get(direction)[1];
        }
        return coordinate;
    }

    public List<int[]> getListOfCoordinates(List<List<String>> instructions) {
        List<int[]> listOfCoordinates = new ArrayList<>();
        for (List<String> instruction:instructions) {
            listOfCoordinates.add(getCoordinate(instruction));
        }
        return listOfCoordinates;
    }


    public int answerPart1() {
        int count = 0;
        List<List<String>> lists = readInstructions();
        List<int[]> listOfCoordinates = getListOfCoordinates(lists);
        for (int i = 0; i < listOfCoordinates.size(); i++) {
            int frequency = 1;
            for (int j = 0; j < listOfCoordinates.size(); j++) {
                if (i==j) continue;;
                if (Arrays.equals(listOfCoordinates.get(i), listOfCoordinates.get(j))) frequency++;
            }
            if (frequency%2 == 1) count++;
        }
        return count;
    }






























}
