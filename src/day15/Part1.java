package day15;

import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        NumberGame numberGame = new NumberGame();
        List<Integer> startingNumbers = List.of(1,20,11,6,12,0);
        numberGame.setStartingNumbers(startingNumbers);
        List<Integer> stopCounts = List.of(2020/*, 30000000*/);

        for (Integer stopCount:stopCounts) {
            int lastNumber = numberGame.buildList(stopCount);
            System.out.println("stopCount:" + stopCount + ", last:" + lastNumber);
        }


    }
}
