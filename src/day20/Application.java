package day20;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        TileAssembler tileAssembler = new TileAssembler();
        List<Tile> input = tileAssembler.read();
        Tile tile3 = input.get(3);
        tile3.print();

        tile3.turn90DegClockwise();
        tile3.print();

        tile3.turn90DegClockwise();
        tile3.print();

        tile3.turn90DegClockwise();
        tile3.print();

        tile3.turn90DegClockwise();
        tile3.print();




    }

}

