package day05;

import FileReader.FileReader;

import java.util.List;
import java.util.stream.Collectors;

public class BoardingPassesReader {
    private final String pathString = "src/day05/input.txt";
    private final FileReader fileReader = new FileReader();
    private final SeatIDCalculator seatIDCalculator = new SeatIDCalculator();

    public List<Double> getSeatIds() {
        List<String> seatCodes = fileReader.read(pathString);
        List<Double> seatIds = seatCodes.stream()
                .map(e -> seatIDCalculator.calculate(e))
                .sorted()
                .collect(Collectors.toList());
        return seatIds;

    }


}
