package day02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LineParser1Test {
    LineParser1 lineParser1 = new LineParser1();

    @ParameterizedTest
    @CsvSource({
            "false, ''",
            "true, 2-7 p: pbhhzpmppb",
            "true, 3-6 h: jkhnhwhx",
            "false, 3-6 h: jknhwhx",
            "true, 11-14 n: nntnjpnnwnqnfgnnnnn",

    })
    void parse(boolean expected, String line) {
        boolean result = lineParser1.parse(line);
        assertEquals(expected, result);
    }
}