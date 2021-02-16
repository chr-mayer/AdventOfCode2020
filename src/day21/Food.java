package day21;

import java.util.Objects;
import java.util.Set;

public class Food {
    private Set<String> ingredients;
    private Set<String> allergens;

    public Food(Set<String> ingredients, Set<String> allergens) {
        this.ingredients = ingredients;
        this.allergens = allergens;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public Set<String> getAllergens() {
        return allergens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;
        Food food = (Food) o;
        return Objects.equals(ingredients, food.ingredients) && Objects.equals(allergens, food.allergens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredients, allergens);
    }

    @Override
    public String toString() {
        return "\n" + ingredients +
                "\n" + allergens +
                "\n";
    }
}
