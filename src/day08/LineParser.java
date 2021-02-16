package day08;

import java.util.List;

public class LineParser {
    public Instruction parse(String line) {
        List<String> cols = List.of(line.split(" "));
        String operation = cols.get(0);
        int parameter = Integer.parseInt(cols.get(1));

        return new Instruction(operation, parameter);
    }
}
