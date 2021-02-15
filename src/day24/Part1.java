package day24;

public class Part1 {
    public static void main(String[] args) {
        Tiler tiler = new Tiler();
        tiler.setPathString("src/day24/input1.txt");
        int count = tiler.answerPart1();
        System.out.println(count);

    }
}
