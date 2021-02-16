package day17;

public class Application {
    public static void main(String[] args) {
        Cubes3dim cubes3dim = new Cubes3dim();
        boolean[][][] startGrid = cubes3dim.createStartGrid();
        System.out.println(startGrid.length);


    }
}
