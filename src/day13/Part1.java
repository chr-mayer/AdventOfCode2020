package day13;

public class Part1 {
    public static void main(String[] args) {
        ShuttleSearcher shuttleSearcher = new ShuttleSearcher();
        int answer = shuttleSearcher.findEarliestBus();
        System.out.println(answer);
    }
}
