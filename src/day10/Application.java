package day10;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ChainCreator chainCreator = new ChainCreator();

        int answerPart1 = chainCreator.getAnswerPart1();
        System.out.println("AnswerPart1: " + answerPart1);
        System.out.println("--------------");

        List<Integer> read = chainCreator.read();
        System.out.println("size= " + read.size());
        System.out.println(read.get(read.size()/2));
        System.out.println(read);
        System.out.println("--------------");

        long answerPart2 = chainCreator.getAnswerPart2();
        System.out.println("AnswerPart2: " + answerPart2);


    }
}
