package day23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CrabCups {
    private String inputString = "389125467";
    public void setInputString(String inputString) {
        this.inputString = inputString;
    }
    private LinkedList<Integer> getInput() {
        return Arrays.stream(inputString.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
    }


    public void playPart2() {
        LinkedList<Integer> inputList = getInput();
        int numberOfMoves = 10000000;
        for (int i = 10; i <= 1000000; i++) {
            inputList.add(i);
        }
        Circle circle = new Circle(inputList);
        int currentCupLabel = circle.getCups().get(0);
        for (int i = 0; i < numberOfMoves; i++) {
            int newCurrentCupLabel = circle.playOneRoundPart2(currentCupLabel);
            currentCupLabel = newCurrentCupLabel;
            if (i%10000 == 0) System.out.println(i);
        }
        List<Integer> result = circle.getCups();
        int i1 = result.indexOf(1);
        long label1 = result.get(i1+1);
        long label2 = result.get(i1+2);
        System.out.println("--------------");
        System.out.println(label1);
        System.out.println(label2);
        long answerPart2 = label1 * label2;
        System.out.println("answerPart2: " + answerPart2);

    }











    public void playPart1() {
        Circle circle = new Circle(getInput());
        System.out.println(circle.getCups());
        int currentCupLabel = circle.getCups().get(0);
        for (int i = 0; i < 100; i++) {
            int newCurrentCupLabel = circle.playOneRound(currentCupLabel);
            currentCupLabel = newCurrentCupLabel;
        }
        List<Integer> result = circle.getCups();
        List<Integer> answerPart1 = new ArrayList<>();
        System.out.println(result);
        int i1 = result.indexOf(1);
        for (int i = 1; i <= 8; i++) {
            answerPart1.add(result.get((i1+i)%9));
        }
        String answerPart1String = answerPart1.stream()
                .map(e -> String.valueOf(e))
                .reduce("", String::concat);
        System.out.println("answerPart1: " + answerPart1String);
    }






























































}
