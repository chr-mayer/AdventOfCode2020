package day02;

import java.util.List;

public class LineParser2 {
    public boolean parse(String line) {
        List<String> columns = List.of(line.split(" "));
        String range = columns.get(0);
        String letter = columns.get(1).replace(":", "");
        String password = columns.get(2);

        List<String> limits = List.of(range.split("-"));
        int pos1 = Integer.parseInt(limits.get(0));
        int pos2 = Integer.parseInt(limits.get(1));

        CharacterPositionVerifier characterPositionVerifier = new CharacterPositionVerifier();
        return (characterPositionVerifier.verify(pos1, letter, password) ^ characterPositionVerifier.verify(pos2, letter, password));


    }


}
