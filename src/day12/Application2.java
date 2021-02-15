package day12;

public class Application2 {
    public static void main(String[] args) {
        Ship ship3 = new Ship();
        ship3.setWaypoint(new Point(-9, 0));
        System.out.println(ship3.getWaypoint().getEast());
        System.out.println(ship3.getWaypoint().getNorth());
        System.out.println();
        System.out.println();

        ship3.turnWaypoint90right();
        System.out.println("---");
        System.out.println(ship3.getWaypoint().getEast());
        System.out.println(ship3.getWaypoint().getNorth());

        ship3.turnWaypoint90right();
        System.out.println("---");
        System.out.println(ship3.getWaypoint().getEast());
        System.out.println(ship3.getWaypoint().getNorth());

        ship3.turnWaypoint90right();
        System.out.println("---");
        System.out.println(ship3.getWaypoint().getEast());
        System.out.println(ship3.getWaypoint().getNorth());

        ship3.turnWaypoint90right();
        System.out.println("---");
        System.out.println(ship3.getWaypoint().getEast());
        System.out.println(ship3.getWaypoint().getNorth());



    }
}
