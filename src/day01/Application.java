package day01;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        TwoSummandsFinder twoSummandsFinder = new TwoSummandsFinder();
        List<List<Integer>> matchingPairs = twoSummandsFinder.find();
        System.out.println("size=" + matchingPairs.size());
        for (List<Integer> matchingPair : matchingPairs) {
            int number1 = matchingPair.get(0);
            int number2 = matchingPair.get(1);
            int product = number1 * number2;
            System.out.println("number1: " + number1);
            System.out.println("number2: " + number2);
            System.out.println("number1 + number2 =  ".concat(String.valueOf(number1 + number2)));
            System.out.println(number1 + " x " + number2 + " = " + product);
            System.out.println("-------------");
        }

        System.out.println("#####################");
        ThreeSummandsFinder threeSummandsFinder = new ThreeSummandsFinder();
        List<List<Integer>> matchingTriples = threeSummandsFinder.find();
        System.out.println("size=" + matchingTriples.size());
        for (List<Integer> matchingTriple : matchingTriples) {
            int number1 = matchingTriple.get(0);
            int number2 = matchingTriple.get(1);
            int number3 = matchingTriple.get(2);
            int product = number1 * number2 * number3;
            System.out.println("number1: " + number1);
            System.out.println("number2: " + number2);
            System.out.println("number3: " + number3);
            System.out.println("number1 + number2 + number3 =  ".concat(String.valueOf(number1 + number2 + number3)));
            System.out.println(number1 + " x " + number2 + " x " + number3 + " = " + product);
            System.out.println("-------------");
        }

    }
}

