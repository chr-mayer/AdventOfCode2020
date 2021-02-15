package day21;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        FoodChecker foodChecker = new FoodChecker();
        //foodChecker.setPathString("src/day21/input1.txt");
        List<Food> read = foodChecker.read();
        System.out.println(read);


    }
}
