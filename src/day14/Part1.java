package day14;

public class Part1 {
    public static void main(String[] args) {
        Emulator emulator = new Emulator();
        long sum = emulator.processInstructions1();
        System.out.println(sum);

    }
}
