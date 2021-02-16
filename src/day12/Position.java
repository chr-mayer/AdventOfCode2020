package day12;

public class Position {
    private int east;
    private int north;
    private CompassDirection orientation;

    public Position(int east, int north, CompassDirection orientation) {
        this.east = east;
        this.north = north;
        this.orientation = orientation;
    }

    public int getEast() {
        return east;
    }

    public void setEast(int east) {
        this.east = east;
    }

    public int getNorth() {
        return north;
    }

    public void setNorth(int north) {
        this.north = north;
    }

    public CompassDirection getOrientation() {
        return orientation;
    }

    public void setOrientation(CompassDirection orientation) {
        this.orientation = orientation;
    }



}
