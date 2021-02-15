package day06;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswersCounter1 {
    private String pathString = "src/day06/input.txt";
    private FileReader fileReader = new FileReader();

    public int count() {
        List<String> lines = fileReader.read(pathString);
        List<Set<String>> listOfGroupAnswers = new ArrayList<>();
        Set<String> group1 = new HashSet<>();
        listOfGroupAnswers.add(group1);
        for (int i = 0; i < lines.size(); i++) {
            String currentLine = lines.get(i);
            if (!currentLine.isEmpty()) {
                Set<String> last = listOfGroupAnswers.get(listOfGroupAnswers.size() - 1);
                List<String> letters = List.of(currentLine.split(""));
                for (String letter : letters) {
                    last.add(letter);
                }
            } else {
                listOfGroupAnswers.add(new HashSet<>());
            }
        }
        Integer sum = listOfGroupAnswers.stream()
                .map(e -> e.size())
                .reduce(0, (a, b) -> a + b);


        return sum;
    }

}
