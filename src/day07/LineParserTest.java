package day07;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LineParserTest {
    LineParser lineParser = new LineParser();

    static Stream<Arguments> testdata() {
        return Stream.of(
                Arguments.of(
                        new Bag("light red",
                                List.of(new StorageSlot(1, "bright white"),
                                        new StorageSlot(2, "muted yellow"))),
                        "light red bags contain 1 bright white bag, 2 muted yellow bags."

                ),
                Arguments.of(
                        new Bag("dark orange",
                                List.of(new StorageSlot(3, "bright white"),
                                        new StorageSlot(4, "muted yellow"))),
                        "dark orange bags contain 3 bright white bags, 4 muted yellow bags."

                ),
                Arguments.of(
                        new Bag("muted yellow",
                                List.of(new StorageSlot(2, "shiny gold"),
                                        new StorageSlot(9, "faded blue"))),
                        "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags."

                ),
                Arguments.of(
                        new Bag("dotted black",
                                List.of()),
                        "dotted black bags contain no other bags."

                ),
                Arguments.of(
                        new Bag("dotted lavender",
                                List.of(new StorageSlot(1, "striped white"),
                                        new StorageSlot(5, "dotted coral"),
                                        new StorageSlot(3, "striped orange"),
                                        new StorageSlot(1, "dotted gray"))),
                        "dotted lavender bags contain 1 striped white bag, 5 dotted coral bags, 3 striped orange bags, 1 dotted gray bag."

                )
        );
    }

    @ParameterizedTest
    @MethodSource("testdata")
    void parse(Bag expected, String input) {
        Bag result = lineParser.parse(input);
        assertEquals(expected, result);
    }
}








