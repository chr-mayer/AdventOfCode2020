package day17;

public class Part2 {
    public static void main(String[] args) {
        Cubes4dim cubes4dim = new Cubes4dim();
        boolean[][][][] startGrid = cubes4dim.createStartGrid();
        boolean[][][][] output = cubes4dim.simulateSixCycleBootProcess();
        System.out.println(cubes4dim.countActiveCells(output));
    }
}
