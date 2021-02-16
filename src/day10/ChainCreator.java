package day10;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChainCreator {
    private String pathString = "src/day10/input.txt";
    private FileReader fileReader = new FileReader();


    public List<Integer> read() {
        List<Integer> numbers = fileReader.read(pathString).stream()
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        numbers.add(0, 0);
        numbers.add(numbers.get(numbers.size() - 1) + 3);
        return numbers;
    }


    public int getAnswerPart1() {
        List<Integer> numbers = read();
        List<Integer> differences = new ArrayList<>();
        for (int i = 1; i < numbers.size(); i++) {
            int diff = numbers.get(i) - numbers.get(i - 1);
            if (diff > 3) {
                System.out.println("diff > 3");
            }
            differences.add(diff);
        }
        int diff1 = 0;
        int diff3 = 0;
        for (Integer diff : differences) {
            if (diff == 1) {
                diff1++;
            }
            if (diff == 3) {
                diff3++;
            }
        }
        return diff1 * diff3;
    }


    public long getNumberOfPaths(List<Integer> numbers) {
        List<Integer> listOfEndpoints = new ArrayList<>();
        listOfEndpoints.add(numbers.get(0));
        while (!listOfEndpoints.isEmpty()) {
            List<Integer> newListOfEndpoints = new ArrayList<>();
            for (Integer endpoint : listOfEndpoints) {
                int indexOfEndpoint = numbers.indexOf(endpoint);
                if (indexOfEndpoint == numbers.size() - 1) {
                    newListOfEndpoints.add(numbers.get(indexOfEndpoint));
                    continue;
                }
                int j = indexOfEndpoint + 1;
                while (numbers.get(j) - numbers.get(indexOfEndpoint) <= 3) {
                    newListOfEndpoints.add(numbers.get(j));
                    if (j < numbers.size() - 1) {
                        j++;
                    } else {
                        break;
                    }
                }
            }
            if (newListOfEndpoints.equals(listOfEndpoints)) {
                break;
            } else {
                listOfEndpoints = new ArrayList<>(newListOfEndpoints);
            }
        }
        return listOfEndpoints.size();
    }


    public long getAnswerPart2() {
        List<Integer> numbers = read();
        int sizeOfNumbers = numbers.size();
        int splitIndex = 0;
        if (sizeOfNumbers % 2 == 0) {
            splitIndex = sizeOfNumbers / 2;
        } else {
            splitIndex = (sizeOfNumbers / 2) + 1;
        }
        System.out.println("splitIndex= " + splitIndex);
        System.out.println("value at splitIndex= " + numbers.get(splitIndex));
        List<Integer> numbers1 = new ArrayList<>(numbers.subList(0, splitIndex + 1));
        List<Integer> numbers2 = new ArrayList<>(numbers.subList(splitIndex + 1, numbers.size()));
        numbers1.add(numbers1.get(numbers1.size()-1) + 3);
        numbers2.add(0, numbers2.get(0) - 3);
        System.out.println(numbers1);
        System.out.println(numbers2);
        long count = getNumberOfPaths(numbers1) * getNumberOfPaths(numbers2);
        System.out.println(getNumberOfPaths(numbers1));
        System.out.println(getNumberOfPaths(numbers2));
        System.out.println(getNumberOfPaths(numbers1) + " * " + getNumberOfPaths(numbers2) + " = " + count);


        return count;

    }




















































}
