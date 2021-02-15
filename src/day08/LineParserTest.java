package day08;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LineParserTest {
    LineParser lineParser = new LineParser();

    static Stream<Arguments> testdata() {
        return Stream.of(
                Arguments.of(new Instruction("acc", 50), "acc +50"),
                Arguments.of(new Instruction("acc", -11), "acc -11")
        );
    }

    @ParameterizedTest
    @MethodSource("testdata")
    void parse(Instruction expected, String input) {
        Instruction result = lineParser.parse(input);
        assertEquals(expected, result);
    }
}