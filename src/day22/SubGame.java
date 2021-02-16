package day22;

import java.util.*;

public class SubGame {
    private List<Integer> deck1;
    private List<Integer> deck2;
    private int roundsPlayed;
    private HashMap<Integer, List<List<Integer>>> previousRounds;

    public List<Integer> getDeck1() {
        return deck1;
    }

    public List<Integer> getDeck2() {
        return deck2;
    }

    public SubGame(List<Integer> deck1, List<Integer> deck2) {
        this.deck1 = deck1;
        this.deck2 = deck2;
        this.roundsPlayed = 0;
        this.previousRounds = new HashMap<>(Map.of(0, List.of(new ArrayList<>(deck1), new ArrayList<>(deck2))));
    }

    public int play() {

        while (deck1.size() != 0 && deck2.size() != 0) {
            if (roundsPlayed != 0 && previousRounds.containsValue(List.of(deck1, deck2))) {
                return 1;
            }

            previousRounds.put(roundsPlayed, List.of(new ArrayList<>(deck1), new ArrayList<>(deck2)));

            Integer player1TopCard = deck1.get(0);
            Integer player2TopCard = deck2.get(0);
            deck1.remove(0);
            deck2.remove(0);
            int size1 = deck1.size();
            int size2 = deck2.size();

            if (size1 < player1TopCard || size2 < player2TopCard) {
                if (player1TopCard > player2TopCard) {
                    deck1.add(player1TopCard);
                    deck1.add(player2TopCard);
                } else if (player1TopCard < player2TopCard) {
                    deck2.add(player2TopCard);
                    deck2.add(player1TopCard);
                } else System.out.println("unexpected input data: ");


            } else {
                List<Integer> subDeck1 = new ArrayList<>(deck1.subList(0, player1TopCard));
                List<Integer> subDeck2 = new ArrayList<>(deck2.subList(0, player2TopCard));
                SubGame subGame = new SubGame(subDeck1, subDeck2);
                int winnerOfSubGame = subGame.play();
                if (winnerOfSubGame == 1) {
                    deck1.add(player1TopCard);
                    deck1.add(player2TopCard);
                } else if (winnerOfSubGame == 2) {
                    deck2.add(player2TopCard);
                    deck2.add(player1TopCard);
                } else System.out.println("unexpected input data: ");
            }

            roundsPlayed++;
        }


        if (deck1.size() == 0) return 2;
        else return 1;



    }


}
