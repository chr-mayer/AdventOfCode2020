package day13;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShuttleSearcher {
    //private final String pathString = "src/day13/sample_input.txt";
    private final String pathString = "src/day13/input.txt";
    private final FileReader fileReader = new FileReader();


    public List<List<Integer>> readInput() {
        List<String> lines = fileReader.read(pathString);
        int earliestTimestamp = Integer.parseInt(lines.get(0));
        String[] splitted = lines.get(1).split(",");
        List<String> busIDStrings = Arrays.asList(splitted);
        List<Integer> busIDs = new ArrayList<>();
        for (String busIDString : busIDStrings) {
            int busID = 0;
            if (busIDString.equals("x")) {
                busIDs.add(busID);
                continue;
            }
            try {
                busID = Integer.parseInt(busIDString);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            busIDs.add(busID);
        }
        return List.of(List.of(earliestTimestamp), busIDs);
    }


    public int findEarliestBus() {
        Integer earliestTimestamp = readInput().get(0).get(0);
        List<Integer> busIDs = readInput().get(1).stream()
                .filter(e -> !e.equals(0))
                .collect(Collectors.toList());
        int i = earliestTimestamp;
        int firstBus = 0;
        while (true) {
            for (Integer busID : busIDs) {
                if (isFactor(i, busID)) {
                    firstBus = busID;
                    return (i - earliestTimestamp) * firstBus;
                }
            }
            i++;
        }
    }


    public boolean isFactor(long i, Integer busID) {
        long remainder = i % busID;
        if (remainder == 0) return true;
        else return false;
    }



    public long findEarliestTimestamp1() {
        List<Integer> busIDList = readInput().get(1);

        List<Integer> timeOffsets = new ArrayList<>();
        for (Integer busID : busIDList) {
            if (busID == 0) continue;
            timeOffsets.add(busIDList.indexOf(busID));
        }
        long i = 1;
        while (true) {
            boolean okForAllJ = true;
            for (int j = 0; j < timeOffsets.size(); j++) {
                long timestampJ = i + timeOffsets.get(j);
                int busIdOfThatTimestamp = busIDList.get(timeOffsets.get(j));
                boolean isFactorOfThatTimestamp = isFactor(timestampJ, busIdOfThatTimestamp);
                okForAllJ = okForAllJ && isFactorOfThatTimestamp;
                //if (j == timeOffsets.size() - 1)  System.out.println("j == timeOffsets.size()-1");
                if (!okForAllJ) break;
            }
            if (okForAllJ) {
                return i;
            } else i++;
        }
    }




    public long findEarliestTimestamp() {
        List<Integer> busIDList = readInput().get(1);

        List<Integer> timeOffsets = new ArrayList<>();
        for (Integer busID : busIDList) {
            if (busID == 0) continue;
            timeOffsets.add(busIDList.indexOf(busID));
        }

        long i = 0L;
        long stepsize = busIDList.get(timeOffsets.get(0));

        while (true) {

            int all = 0;
            for (int j = 0; j < timeOffsets.size(); j++) {
                long timestamp = i + timeOffsets.get(j);
                Integer busID = busIDList.get(timeOffsets.get(j));
                if (timestamp % busID != 0) {
                    i = i + stepsize;
                    all++;
                    break;
                } else {
                    if (stepsize % busID != 0) stepsize = stepsize * busID;
                }
            }
            if (all == 0) break;


        }






        return i;
    }





























}
















































