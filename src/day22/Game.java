package day22;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String pathString = "src/day22/sample_input.txt";
    private FileReader fileReader = new FileReader();

    public void setPathString(String pathString) {
        this.pathString = pathString;
        startingDeck1 = read().get(0);
        startingDeck2 = read().get(1);
    }
    private List<Integer> startingDeck1 = read().get(0);
    private List<Integer> startingDeck2 = read().get(1);
    private int roundsPlayed = 0;

    public List<Integer> getStartingDeck1() {
        return startingDeck1;
    }

    public List<Integer> getStartingDeck2() {
        return startingDeck2;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public List<List<Integer>> read() {
        List<Integer> startingDeck1 = new ArrayList<>();
        List<Integer> startingDeck2 = new ArrayList<>();
        List<String> lines = fileReader.read(pathString);
        int size = lines.size();

        int i1 = lines.indexOf("Player 1:") + 1;
        int i2 = lines.indexOf("Player 2:") + 1;

        while (!lines.get(i1).isEmpty()) {
            startingDeck1.add(Integer.parseInt(lines.get(i1)));
            i1++;
        }

        while (!lines.get(i2).isEmpty()) {
            startingDeck2.add(Integer.parseInt(lines.get(i2)));
            i2++;
            if (!(i2 <= size-1)) break;
        }

        return List.of(startingDeck1, startingDeck2);
    }

    public void playOneRound() {
        Integer player1TopCard = startingDeck1.get(0);
        Integer player2TopCard = startingDeck2.get(0);
        startingDeck1.remove(0);
        startingDeck2.remove(0);
        if (player1TopCard > player2TopCard) {
            startingDeck1.add(player1TopCard);
            startingDeck1.add(player2TopCard);
        } else if (player1TopCard < player2TopCard) {
            startingDeck2.add(player2TopCard);
            startingDeck2.add(player1TopCard);
        } else System.out.println("unexpected input data");
        roundsPlayed++;
    }

    public void play() {
        while (startingDeck1.size() != 0 && startingDeck2.size() != 0) {
            playOneRound();
        }
        if (startingDeck1.size() == 0) {
            System.out.println("Player 2 wins after " + roundsPlayed + " rounds.");
            System.out.println(calculateScore(startingDeck2));
        }
        if (startingDeck2.size() == 0) {
            System.out.println("Player 1 wins after " + roundsPlayed + " rounds.");
            System.out.println(calculateScore(startingDeck1));
        }


    }

    private int calculateScore(List<Integer> cardDeck) {
        int size = cardDeck.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum = sum + cardDeck.get(i) * (size - i);
        }
        return sum;
    }


    public void playRecursiveGame() {
        SubGame subGame = new SubGame(startingDeck1, startingDeck2);
        int winner = subGame.play();
        System.out.println(calculateScore(subGame.getDeck1()));
        System.out.println(calculateScore(subGame.getDeck2()));
        System.out.println("winning player: " + winner);


    }























































}
