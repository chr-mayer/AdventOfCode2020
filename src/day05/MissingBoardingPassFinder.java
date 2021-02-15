package day05;

import java.util.ArrayList;
import java.util.List;

public class MissingBoardingPassFinder {
    private final BoardingPassesReader boardingPassesReader = new BoardingPassesReader();

    public List<Double> findCandidates() {
        List<Double> seatIds = boardingPassesReader.getSeatIds();
        int size = seatIds.size();
        Double maximum = seatIds.get(size - 1);

        List<Double> candidates = new ArrayList<>();
        for (int i = 1; i <= maximum; i++) {
            Double d = Double.valueOf(i);
            if (!seatIds.contains(d)) {
                if (seatIds.contains(d - 1) && seatIds.contains(d + 1)) {
                    candidates.add(d);
                }
            }
        }
        return candidates;
    }


}
