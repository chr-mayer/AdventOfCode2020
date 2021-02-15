package day15;

import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        //NumberGame numberGame = new NumberGame();
        //List<Integer> startingNumbers = List.of(0,3,6);
        List<Integer> startingNumbers = List.of(6,4,12,1,20,0,16);
        //List<Integer> startingNumbers = List.of(1,20,11,6,12,0);
        //List<Integer> startingNumbers = List.of(0,13,16,17,1,10,6);

        List<Integer> stopCounts = List.of(2020, 30000000);

        System.out.println("-----------");
        for (Integer stopCount:stopCounts) {
            NumberGame numberGame = new NumberGame();
            numberGame.setStartingNumbers(startingNumbers);
            int lastNumber = numberGame.getNumberAt(stopCount);
            System.out.println("stopCount:" + stopCount + ", last:" + lastNumber);
            System.out.println("-----------");
        }


    }
}
