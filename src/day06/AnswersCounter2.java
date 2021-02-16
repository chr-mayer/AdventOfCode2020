package day06;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswersCounter2 {
    private String pathString = "src/day06/input.txt";
    private FileReader fileReader = new FileReader();

    public int count() {
        List<String> lines = fileReader.read(pathString);
        List<Set<String>> listOfGroupAnswers = new ArrayList<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Set<String> group1 = new HashSet<>(List.of(alphabet.split("")));
        listOfGroupAnswers.add(group1);
        for (int i = 0; i < lines.size(); i++) {
            String currentLine = lines.get(i);
            if (!currentLine.isEmpty()) {
                Set<String> last = listOfGroupAnswers.get(listOfGroupAnswers.size() - 1);
                //System.out.println(last);
                Set<String> letters = new HashSet<>(List.of(currentLine.split("")));
                last.retainAll(letters);
                //System.out.println(last);
                //System.out.println("---");
            } else {
                listOfGroupAnswers.add(new HashSet<>(List.of(alphabet.split(""))));
                //System.out.println("°°°");
            }
        }
        Integer sum = listOfGroupAnswers.stream()
                .map(e -> e.size())
                .reduce(0, (a, b) -> a + b);


        return sum;
    }

}
