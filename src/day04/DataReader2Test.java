package day04;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataReader2Test {
    DataReader2 dataReader2 = new DataReader2();

    static Stream<Arguments> testdata() {
        return Stream.of(
                Arguments.of(true, new Passport(
                        "1992",
                        "2013",
                        "2024",
                        "183cm",
                        "#7d3b0c",
                        "oth",
                        "138000309",
                        "135"
                ))
        );
    }


    @ParameterizedTest
    @MethodSource("testdata")
    void isValidByr(boolean expected, Passport input) {
        boolean result = dataReader2.isValidByr(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testdata")
    void isValidIyr(boolean expected, Passport input) {
        boolean result = dataReader2.isValidIyr(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testdata")
    void isValidEyr(boolean expected, Passport input) {
        boolean result = dataReader2.isValidEyr(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testdata")
    void isValidHgt(boolean expected, Passport input) {
        boolean result = dataReader2.isValidHgt(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testdata")
    void isValidHcl(boolean expected, Passport input) {
        boolean result = dataReader2.isValidHcl(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testdata")
    void isValidEcl(boolean expected, Passport input) {
        boolean result = dataReader2.isValidEcl(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("testdata")
    void isValidPid(boolean expected, Passport input) {
        boolean result = dataReader2.isValidPid(input);
        assertEquals(expected, result);
    }
}