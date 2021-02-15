package day07;

public class Application {
    public static void main(String[] args) {
        OuterBagsFinder outerBagsFinder = new OuterBagsFinder();
/*        int bagsToBuy = outerBagsFinder.countBagsToBuy();
        System.out.println(bagsToBuy);*/
        System.out.println("------------------------------");

        // outerBagsFinder.printbagMap();




        long bagsToBuy = outerBagsFinder.countBagsToBuy();
        System.out.println("------------------------------");
        System.out.println(bagsToBuy);


    }
}
