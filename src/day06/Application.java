package day06;

public class Application {
    public static void main(String[] args) {
        AnswersCounter1 answersCounter1 = new AnswersCounter1();
        int count1 = answersCounter1.count();
        System.out.println(count1);

        System.out.println("____________");
        System.out.println("");

        AnswersCounter2 answersCounter2 = new AnswersCounter2();
        int count2 = answersCounter2.count();
        System.out.println(count2);

    }
}
