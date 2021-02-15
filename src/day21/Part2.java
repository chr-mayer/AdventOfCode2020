package day21;

public class Part2 {
    public static void main(String[] args) {
        FoodChecker foodChecker = new FoodChecker();
        foodChecker.setPathString("src/day21/input.txt");
        String answer = foodChecker.ingredientsToAllergens();
        System.out.println(answer);
    }
}
