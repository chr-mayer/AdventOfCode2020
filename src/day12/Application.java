package day12;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Ship ship1 = new Ship();
        ship1.setPosition(new Position(0, 0, CompassDirection.E));
        List<NavInstruction> navInstructions1 = ship1.readInput();
        ship1.navigate(navInstructions1);
        int east1 = ship1.getPosition().getEast();
        int north1 = ship1.getPosition().getNorth();
        CompassDirection orientation1 = ship1.getPosition().getOrientation();

        System.out.println("east: " + east1);
        System.out.println("north: " + north1);
        System.out.println("orientation: " + orientation1);

        int mh1 = Math.abs(east1) + Math.abs(north1);
        System.out.println("manhattan distance: " + mh1);

        System.out.println("---------------------------------------------------------");
        System.out.println();

        Ship ship2 = new Ship();
        ship2.setPosition(new Position(0, 0, CompassDirection.E));
        ship2.setWaypoint(new Point(10,1));
        List<NavInstruction> navInstructions2 = ship2.readInput();
        ship2.navigate2(navInstructions2);

        int east2 = ship2.getPosition().getEast();
        int north2 = ship2.getPosition().getNorth();

        System.out.println("east: " + east2);
        System.out.println("north: " + north2);

        int mh2 = Math.abs(east2) + Math.abs(north2);
        System.out.println("manhattan distance: " + mh2);





    }
}
