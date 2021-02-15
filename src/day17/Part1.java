package day17;

public class Part1 {
    public static void main(String[] args) {
        Cubes3dim cubes3dim = new Cubes3dim();
        boolean[][][] startGrid = cubes3dim.createStartGrid();
        boolean[][][] output = cubes3dim.simulateSixCycleBootProcess();
        System.out.println(cubes3dim.countActiveCells(output));

    }
}
