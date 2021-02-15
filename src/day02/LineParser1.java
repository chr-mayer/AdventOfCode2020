package day02;

import java.util.List;

public class LineParser1 {
    public boolean parse(String line) {
        List<String> columns = List.of(line.split(" "));
        String range = columns.get(0);
        String letter = columns.get(1).replace(":", "");
        String password = columns.get(2);

        List<String> limits = List.of(range.split("-"));
        int min = Integer.parseInt(limits.get(0));
        int max = Integer.parseInt(limits.get(1));

        CharacterCounter characterCounter = new CharacterCounter();
        int frequencyOfLetter = characterCounter.count(letter, password);
        return (frequencyOfLetter >= min && frequencyOfLetter <= max);

    }
}
