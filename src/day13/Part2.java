package day13;

public class Part2 {
    public static void main(String[] args) {
        ShuttleSearcher shuttleSearcher = new ShuttleSearcher();
        long earliestTimestamp = shuttleSearcher.findEarliestTimestamp();
        System.out.println(earliestTimestamp);
    }

}
