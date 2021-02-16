package day20;

public class Part1 {
    public static void main(String[] args) {
        TileAssembler tileAssembler = new TileAssembler();
        //List<List<Tile>> image = tileAssembler.assemble();
        int numberOfMonsters = tileAssembler.findMonsters();
        System.out.println("Number of Monsters: " + numberOfMonsters);
        System.out.println("Answer Part 2: " + (tileAssembler.countHashes() - numberOfMonsters * 15));

    }

}
