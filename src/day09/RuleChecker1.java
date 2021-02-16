package day09;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RuleChecker1 {
    private String pathString = "src/day09/input.txt";
    private int preambleLength = 25;
    private FileReader fileReader = new FileReader();

    

    
    public List<Long> read() {
        List<String> inputLines = fileReader.read(pathString);
        List<Long> inputNumbers = new ArrayList<>();
        for (String line:inputLines) {
            try {
                inputNumbers.add(Long.parseLong(line));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return inputNumbers;
    }

    
    
    
    public Optional<Long> check() {
        List<Long> inputNumbers = read();
        for (int i = preambleLength; i < inputNumbers.size(); i++) {
            List<Long> subList = inputNumbers.subList(i - preambleLength, i);
            if (!isSumOfTwo(inputNumbers.get(i), subList)) {
                //System.out.println(subList);
                return Optional.of(inputNumbers.get(i));
            }
        }
        return Optional.empty();
    }




    public boolean isSumOfTwo(long numberToCheck, List<Long> subList) {
        List<Long> sortedSubList = new ArrayList<>(subList);
        Collections.sort(sortedSubList);
        for (int j = 0; j < sortedSubList.size() - 1; j++) {
            if (sortedSubList.get(j) >= numberToCheck) {continue;}
            for (int k = j+1; k < sortedSubList.size(); k++) {
                if (sortedSubList.get(k) >= numberToCheck) {continue;}
                if (sortedSubList.get(j) + sortedSubList.get(k) == numberToCheck) {
                    return true;
                }
            }
        }
        return false;
    }




    public Optional<List<Long>> findSummands(long numberToCheck) {
        List<Long> result = new ArrayList<>();
        List<Long> inputNumbers = read();
        for (int i = 0; i < inputNumbers.size() - 1; i++) {
            long sum = inputNumbers.get(i);
            for (int j = i+1; j < inputNumbers.size(); j++) {
                sum = sum + inputNumbers.get(j);
                if (sum == numberToCheck) {
                    for (int k = i; k <= j; k++) {
                        result.add(inputNumbers.get(k));
                    }
                    return Optional.of(result);
                }
                if (sum > numberToCheck) {break;}
            }
        }
        return Optional.empty();
    }


























































}
