package day23;

import java.util.ArrayList;
import java.util.List;

public class Circle {
    private List<Integer> cups;

    public Circle(List<Integer> cups) {
        this.cups = cups;
    }

    public List<Integer> getCups() {
        return cups;
    }


    public int playOneRoundPart2(int currentCupLabel) {
        int size = cups.size();

        int currentCupIndex = cups.indexOf(currentCupLabel);

        int n1 = indexOfNextCup(currentCupIndex);
        int n2 = indexOfNextCup(n1);
        int n3 = indexOfNextCup(n2);
        List<Integer> next3ClockwiseCupLabels = List.of(cups.get(n1), cups.get(n2), cups.get(n3));

        int destinationCupLabel = decrementedCupLabel(currentCupLabel);
        for (int i = 1; i <= 3; i++) {
            if (next3ClockwiseCupLabels.contains(destinationCupLabel)) {
                destinationCupLabel = decrementedCupLabel(destinationCupLabel);
            } else break;
        }

        int destinationCupIndex = cups.indexOf(destinationCupLabel);

        if (currentCupIndex < destinationCupIndex) {
            for (int i = 0; i < 3; i++) {
                Integer removed = cups.remove(currentCupIndex + 1);
                cups.add(destinationCupIndex, removed);
            }
        } else {
            for (int i = 0; i < 3; i++) {
                if (currentCupIndex == 999999) {
                    Integer removed = cups.remove(0);
                    currentCupIndex = 999998;
                    destinationCupIndex--;
                    cups.add(destinationCupIndex+1, removed);
                    destinationCupIndex++;
                    currentCupIndex = 999999;
                } else {
                    Integer removed = cups.remove(currentCupIndex+1);
                    cups.add(destinationCupIndex+1, removed);
                    destinationCupIndex++;
                    currentCupIndex++;
                }
            }


        }

        return indexOfNextCup(currentCupIndex);
    }









    private int indexOfNextCup(int index) {
        if (index == 999999) return 0;
        else return index + 1;
    }

    private int decrementedCupLabel(int cupLabel) {
        if (cupLabel == 1) return 1000000;
        else return cupLabel - 1;
    }


    private int getDestinationCupLabel2(int currentCupLabel) {
        for (int i = 1; i < currentCupLabel; i++) {
            if (cups.contains(currentCupLabel - i)) return currentCupLabel - i;
        }
        for (int i = 1000000; i > currentCupLabel; i--) {
            if (cups.contains(i)) return i;
        }
        return 0;
    }


    public int playOneRound(int currentCupLabel) {
        List<Integer> next3Clockwise = new ArrayList<>();
        int size = cups.size();
        int currentCupIndex = cups.indexOf(currentCupLabel);
        for (int i = 1; i <= 3; i++) {
            int i1 = (currentCupIndex + i) % size;
            next3Clockwise.add(cups.get(i1));
        }

        for (int i = 1; i <= 3; i++) {
            int i1 = (cups.indexOf(currentCupLabel) + 1) % cups.size();
            cups.remove(i1);
        }

        int destinationCupLabel = getDestinationCupLabel(currentCupLabel);
        if (destinationCupLabel == 0) System.out.println("destinationCupLabel == 0");
        int indexOfDestinationCupLabel = cups.indexOf(destinationCupLabel);

        for (int i = 0; i < 3; i++) {
            cups.add(indexOfDestinationCupLabel + i + 1, next3Clockwise.get(i));
        }

        int indexOfNewCurrentCup = (cups.indexOf(currentCupLabel) + 1) % size;
        return cups.get(indexOfNewCurrentCup);
    }

    private int getDestinationCupLabel(int currentCupLabel) {
        for (int i = 1; i < currentCupLabel; i++) {
            if (cups.contains(currentCupLabel - i)) return currentCupLabel - i;
        }
        for (int i = 9; i > currentCupLabel; i--) {
            if (cups.contains(i)) return i;
        }
        return 0;
    }


}
