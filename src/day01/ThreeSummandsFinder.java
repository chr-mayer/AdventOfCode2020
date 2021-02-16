package day01;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSummandsFinder {
    private final FileReader fileReader = new FileReader();
    private final int sum = 2020;

    public List<List<Integer>> find() {
        List<List<Integer>> resultingTriples = new ArrayList<>();
        List<String> numberStrings = fileReader.read("src/aoc/day01/input.txt");
        List<Integer> numbers = numberStrings.stream().map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        int size = numbers.size();
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (numbers.get(i) + numbers.get(j) + numbers.get(k) == sum) {
                        List<Integer> match = new ArrayList<>();
                        match.add(numbers.get(i));
                        match.add(numbers.get(j));
                        match.add(numbers.get(k));
                        resultingTriples.add(match);
                    }
                }

            }
        }
        return resultingTriples;

    }


}
