package day21;

import FileReader.FileReader;

import java.util.*;
import java.util.stream.Collectors;

public class FoodChecker {
    private String pathString = "src/day21/sample_input.txt";
    private FileReader fileReader = new FileReader();

    public void setPathString(String pathString) {
        this.pathString = pathString;
    }

    public List<Food> read() {
        List<Food> foodList = new ArrayList<>();
        List<String> lines = fileReader.read(pathString);
        for (String line : lines) {
            Food food = parseLine(line);
            foodList.add(food);
        }
        return foodList;
    }


    private Food parseLine(String line) {
        String[] splitted1 = line.split(" \\(contains ");
        Set<String> ingredients = Set.of(splitted1[0].split(" "));
        Set<String> allergens = Set.of(splitted1[1].replace(")", "").split(", "));
        return new Food(new HashSet<>(ingredients), new HashSet<>(allergens));
    }


    public List<Object> ingredientsThatCantContainAnyAllergen() {
        List<Food> foodList = read();
        Set<String> allergens = foodList.stream()
                .map(e -> e.getAllergens())
                .reduce(new HashSet<>(), (a, b) -> {
                    a.addAll(b);
                    return a;
                });
        for (String allergen : allergens) {
            List<Food> foodsContainingThisAllergen = foodsContaining(allergen);
            Set<String> sharedIngredients = foodsContainingThisAllergen.stream()
                    .map(e -> e.getIngredients())
                    .reduce((a, b) -> {
                        a.retainAll(b);
                        return a;
                    })
                    .orElse(new HashSet<>());
            for (Food food : foodList) {
                food.getIngredients().removeAll(sharedIngredients);
            }
        }
        Set<String> ingredientsThatCantContainAnyAllergen = foodList.stream()
                .map(e -> e.getIngredients())
                .reduce(new HashSet<>(), (a, b) -> {
                    a.addAll(b);
                    return a;
                });
        int answerPart1 = foodList.stream()
                .map(e -> e.getIngredients().size())
                .reduce(0, Integer::sum);
        return List.of(answerPart1, ingredientsThatCantContainAnyAllergen);
    }


    private List<Food> foodsContaining(String allergen) {
        List<Food> foodList = read();
        return foodList.stream()
                .filter(e -> e.getAllergens().contains(allergen))
                .collect(Collectors.toList());
    }


    public String ingredientsToAllergens() {
        List<Food> foodList = read();
        Set<String> ingredientsThatCantContainAnyAllergen = (Set<String>) ingredientsThatCantContainAnyAllergen().get(1);
        foodList.stream()
                .forEach(e -> e.getIngredients().removeAll(ingredientsThatCantContainAnyAllergen));


        Set<String> ingredientsInTotal = foodList.stream()
                .map(e -> e.getIngredients())
                .reduce(new HashSet<>(), (a, b) -> {
                    a.addAll(b);
                    return a;
                });

        Set<String> allergensInTotal = foodList.stream()
                .map(e -> e.getAllergens())
                .reduce(new HashSet<>(), (a, b) -> {
                    a.addAll(b);
                    return a;
                });
/*        System.out.println(ingredientsInTotal);
        System.out.println(allergensInTotal);
        System.out.println();*/


        Map<String, Set<String>> mapping = new HashMap<>();
        for (String allergen : allergensInTotal) {
            Set<String> candidates = foodList.stream()
                    .filter(e -> e.getAllergens().contains(allergen))
                    .map(e -> e.getIngredients())
                    .reduce(new HashSet<>(ingredientsInTotal), (a, b) -> {
                        a.retainAll(b);
                        return a;
                    });
            mapping.put(allergen, candidates);
        }

/*        for (Map.Entry<String, Set<String>> entry:mapping.entrySet()) {
            System.out.println(entry);
        }
        System.out.println("__________");*/

        Map<String, String> output = new HashMap<>();

        Map.Entry<String, Set<String>> toReplace = mapping.entrySet().stream()
                .filter(e -> e.getValue().size() == 1)
                .collect(Collectors.toList()).get(0);
        Set<String> next = toReplace.getValue();

        while (!mapping.entrySet().stream()
                .filter(e -> e.getValue().size() > 1)
                .collect(Collectors.toList()).isEmpty()) {

            mapping.remove(toReplace.getKey());
            output.put(toReplace.getKey(), toReplace.getValue().iterator().next());

            List<Map.Entry<String, Set<String>>> tmp1 = mapping.entrySet().stream()
                    .filter(e -> e.getValue().size() > 1)
                    .collect(Collectors.toList());
            for (Map.Entry<String, Set<String>> entry:tmp1) {
                entry.getValue().removeAll(next);
            }

            toReplace = mapping.entrySet().stream()
                    .filter(e -> e.getValue().size() == 1)
                    .collect(Collectors.toList()).get(0);
            next = toReplace.getValue();

        }

        for (Map.Entry<String, Set<String>> entry:mapping.entrySet()) {
            output.put(entry.getKey(), entry.getValue().iterator().next());
        }


        for (Map.Entry<String, String> entry:output.entrySet()) {
            System.out.println(entry);
        }
        System.out.println();


        TreeMap<String, String> stringStringTreeMap = new TreeMap<>(output);

        for (Map.Entry<String, String> entry:stringStringTreeMap.entrySet()) {
            System.out.println(entry);
        }

        String answerPart2 = stringStringTreeMap.entrySet().stream()
                .map(e -> e.getValue())
                .reduce((a, b) -> a.concat(",").concat(b))
                .orElse("");


        //System.out.println(foodList);
        return answerPart2;
    }


}



































