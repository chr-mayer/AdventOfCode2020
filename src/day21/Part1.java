package day21;

import java.util.Set;

public class Part1 {
    public static void main(String[] args) {
        FoodChecker foodChecker = new FoodChecker();
        foodChecker.setPathString("src/day21/input.txt");
        int count = (int) foodChecker.ingredientsThatCantContainAnyAllergen().get(0);
        System.out.println(count);
        Set<String> ingredientsThatCantContainAnyAllergen = (Set<String>) foodChecker.ingredientsThatCantContainAnyAllergen().get(1);
        System.out.println(ingredientsThatCantContainAnyAllergen);
        System.out.println(ingredientsThatCantContainAnyAllergen.size());

    }
}
