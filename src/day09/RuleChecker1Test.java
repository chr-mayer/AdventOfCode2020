package day09;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RuleChecker1Test {
    RuleChecker1 ruleChecker1 = new RuleChecker1();

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(true, 40L, new ArrayList<Long>(List.of(35L, 20L, 15L, 25L, 47L))),
                Arguments.of(true, 62L, new ArrayList<Long>(List.of(20L, 15L, 25L, 47L, 40L))),
                Arguments.of(true, 102L, new ArrayList<Long>(List.of(40L, 62L, 55L, 65L, 95L))),
                Arguments.of(true, 182L, new ArrayList<Long>(List.of(65L, 95L, 102L, 117L, 150L))),
                Arguments.of(false, 127L, new ArrayList<Long>(List.of(95L, 102L, 117L, 150L, 182L))),
                Arguments.of(true, 299L, new ArrayList<Long>(List.of(219L, 127L, 182L, 150L, 117L)))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void check(boolean expected, long numberToCheck, List<Long> subList) {
        boolean result = ruleChecker1.isSumOfTwo(numberToCheck, subList);
        assertEquals(expected, result);
    }
}