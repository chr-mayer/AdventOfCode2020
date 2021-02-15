package day16;

import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        TicketChecker ticketChecker = new TicketChecker();
        List<List<String>> lists = ticketChecker.checkNearbyTicketsAgainstAllRules();
        List<String> fieldNames = ticketChecker.reduce(lists);
        System.out.println(fieldNames);
        long puzzleAnswer = ticketChecker.getPuzzleAnswer(fieldNames);
        System.out.println(puzzleAnswer);


    }
}
