package day05;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        BoardingPassesReader boardingPassesReader = new BoardingPassesReader();
        List<Double> seatIds = boardingPassesReader.getSeatIds();
        Double maximum = seatIds.get(seatIds.size() - 1);
        Double minimum = seatIds.get(0);
        System.out.println(maximum);
        System.out.println(minimum);
        System.out.println("_____________________");


        MissingBoardingPassFinder missingBoardingPassFinder = new MissingBoardingPassFinder();
        List<Double> candidates = missingBoardingPassFinder.findCandidates();
        for (Double candidate : candidates) {
            System.out.println(candidate);
        }

    }

}
