package day24;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Tiler tiler = new Tiler();
        List<List<String>> lists = tiler.readInstructions();
        List<int[]> listOfCoordinates = tiler.getListOfCoordinates(lists);
        for (int[] coord:listOfCoordinates) {
            System.out.print(coord[0]);
            System.out.print(", ");
            System.out.print(coord[1]);
            System.out.println();
        }

    }
}
