package day01;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSummandsFinder {
    private final FileReader fileReader = new FileReader();
    private final int sum = 2020;

    public List<List<Integer>> find() {
        List<List<Integer>> resultingPairs = new ArrayList<>();
        List<String> numberStrings = fileReader.read("src/aoc/day01/input.txt");
        List<Integer> numbers = numberStrings.stream().map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        int size = numbers.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (numbers.get(i) + numbers.get(j) == sum) {
                    List<Integer> match = new ArrayList<>();
                    match.add(numbers.get(i));
                    match.add(numbers.get(j));
                    resultingPairs.add(match);
                }
            }
        }
        return resultingPairs;

    }
}
