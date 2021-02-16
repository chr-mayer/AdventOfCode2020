package day02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterPositionVerifierTest {
    CharacterPositionVerifier characterPositionVerifier = new CharacterPositionVerifier();

    @ParameterizedTest
    @CsvSource({
            "true, 1, a, a",
            "false, 2, a, a",
            "false, 1, a, xa",
            "true, 3, b, hfbzbbbbbbbhbbbbbbbb",
            "true, 5, b, hfbzbbbbbbbhbbbbbbbb",
            "false, 99, b, hfbzbbbbbbbhbbbbbbbb"


    })
    void verify(boolean expected, int position, String letter, String word) {
        boolean result = characterPositionVerifier.verify(position, letter, word);
        assertEquals(expected, result);
    }
}