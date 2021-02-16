package day02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterCounterTest {
    CharacterCounter characterCounter = new CharacterCounter();

    @ParameterizedTest
    @CsvSource({
            "0, a, ''",
            "1, a, a",
            "0, a, xyz",
            "2, a, xyzamnaop",
            "11, h, hhhhhhhhhhh"
    })
    void count(int expected, String character, String word) {
        int result = characterCounter.count(character, word);
        assertEquals(expected, result);
    }
}