package day15;

import java.util.*;

public class NumberGame {
    private List<Integer> startingNumbers = List.of(1, 20, 11, 6, 12, 0);
    private Map<Integer, Integer> history = new HashMap<>();

    public void setStartingNumbers(List<Integer> startingNumbers) {
        this.startingNumbers = startingNumbers;
    }


    public Optional<Integer> secondLastOccurrenceOfLastNumber(List<Integer> numbers) {
        int size = numbers.size();
        int last = numbers.get(size - 1);
        for (int i = 0; i < size - 1; i++) {
            int i1 = size - 2 - i;
            if (numbers.get(i1) == last) return Optional.of(i1);
        }
        return Optional.empty();
    }


    public int getNext(List<Integer> numbers) {
        Optional<Integer> secondLastOccurrenceOfLastNumber = secondLastOccurrenceOfLastNumber(numbers);
        if (secondLastOccurrenceOfLastNumber.isEmpty()) return 0;
        return numbers.size() - 1 - secondLastOccurrenceOfLastNumber.get();
    }


    public int buildList(int stopCount) {
        List<Integer> numbers = new ArrayList<>(startingNumbers);
        while (numbers.size() < stopCount) {
            int next = getNext(numbers);
            //System.out.println(next);
            numbers.add(next);

            if (numbers.size() % 100000 == 0) {
                System.out.println(numbers.size());
            }
        }
        return numbers.get(stopCount - 1);
    }


    public int getNumberAt(int stopCount) {
        int size = startingNumbers.size();
        for (int i = 0; i < size - 1; i++) {
            history.put(startingNumbers.get(i), i);
        }
        int lastNumber = startingNumbers.get(size - 1);
        int indexOfLastNumber = size - 1;
        int successor;

        while (indexOfLastNumber < stopCount - 1) {
            if (history.containsKey(lastNumber)) {
                successor = indexOfLastNumber - history.get(lastNumber);
            } else {
                successor = 0;
            }
            history.put(lastNumber, indexOfLastNumber);
            lastNumber = successor;
            indexOfLastNumber++;
/*            if (indexOfLastNumber > stopCount - 10 && indexOfLastNumber < stopCount + 10) {
                System.out.println(indexOfLastNumber);
                System.out.println(lastNumber);
                System.out.println();
            }*/

        }

        return lastNumber;

    }


}
