package day14;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EmulatorTest {
    Emulator emulator = new Emulator();;

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new Instruction(
                                "mask",
                                0,
                                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X") ,
                        "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X"),
                Arguments.of(new Instruction(
                                "mem",
                                8,
                                "11") ,
                        "mem[8] = 11"),
                Arguments.of(new Instruction(
                                "mem",
                                7,
                                "101") ,
                        "mem[7] = 101")
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void parseLine(Instruction expected, String input) {
        Instruction result = emulator.parseLine(input);
        assertEquals(expected, result);
    }






    @ParameterizedTest
    @CsvSource({
            "73, XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X, 11",
            "101, XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X, 101",
            "64, XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X, 0"
    })
    void applyBitmask(long expected, String binmask, int number) {
        long result = emulator.applyBitmask1(binmask, number);
        assertEquals(expected, result);

    }
























}