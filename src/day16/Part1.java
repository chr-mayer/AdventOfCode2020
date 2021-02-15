package day16;

public class Part1 {
    public static void main(String[] args) {
        TicketChecker ticketChecker = new TicketChecker();
        int ticketScanningErrorRate = ticketChecker.getTicketScanningErrorRate();
        System.out.println(ticketScanningErrorRate);

    }
}
