package day14;

public class Part2 {
    public static void main(String[] args) {
        Emulator emulator = new Emulator();
        long sum = emulator.processInstructions2();
        System.out.println(sum);
    }
}
