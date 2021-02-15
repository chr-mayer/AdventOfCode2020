package day05;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeatIDCalculatorTest {
    SeatIDCalculator seatIDCalculator = new SeatIDCalculator();

    @ParameterizedTest
    @CsvSource({
            "567, BFFFBBFRRR",
            "119, FFFBBBFRRR",
            "820, BBFFBBFRLL",
            "357, FBFBBFFRLR"


    })
    void calculate(double expected, String input) {
        double result = seatIDCalculator.calculate(input);
        assertEquals(expected, result);
    }
}




