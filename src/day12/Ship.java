package day12;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ship {
    private String pathString = "src/day12/input.txt";
    private FileReader fileReader = new FileReader();
    private Position position = new Position(0, 0, CompassDirection.valueOf("E"));
    private Point waypoint = new Point(10, 1);


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Point getWaypoint() {
        return waypoint;
    }

    public void setWaypoint(Point waypoint) {
        this.waypoint = waypoint;
    }

    public List<NavInstruction> readInput() {
        List<String> lines = fileReader.read(pathString);
        List<NavInstruction> navInstructions = new ArrayList<>();
        for (String line : lines) {
            List<String> cols = List.of(line.split("", 2));
            String action = cols.get(0);
            int value = 0;
            try {
                value = Integer.parseInt(cols.get(1));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            navInstructions.add(new NavInstruction(action, value));
        }
        return navInstructions;
    }


    public void move(NavInstruction navInstruction) {
        int currentEast = position.getEast();
        int currentNorth = position.getNorth();
        String action = navInstruction.getAction();
        switch (action) {
            case "E":
                position.setEast(currentEast + navInstruction.getValue());
                break;
            case "N":
                position.setNorth(currentNorth + navInstruction.getValue());
                break;
            case "W":
                position.setEast(currentEast - navInstruction.getValue());
                break;
            case "S":
                position.setNorth(currentNorth - navInstruction.getValue());
                break;
            default:
                break;
        }

    }


    public void turn(NavInstruction navInstruction) {
        int currentOrientationOrd = position.getOrientation().ordinal();
        String action = navInstruction.getAction();
        int value = navInstruction.getValue();
        int quarterTurns = value / 90;
        int newOrientationIndex = 0;
        CompassDirection newOrientation = CompassDirection.values()[0];
        switch (action) {
            case "R":
                newOrientationIndex = ((currentOrientationOrd + quarterTurns) % 4);
                newOrientation = CompassDirection.values()[newOrientationIndex];
                position.setOrientation(newOrientation);
                break;
            case "L":
                newOrientationIndex = (currentOrientationOrd + 4 - quarterTurns) % 4;
                newOrientation = CompassDirection.values()[newOrientationIndex];
                position.setOrientation(newOrientation);
                break;
            default:
                break;
        }
    }


    public void navigate(List<NavInstruction> navInstructions) {
        List<String> compassDirectionStrings = Arrays.stream(CompassDirection.values())
                .map(e -> e.toString())
                .collect(Collectors.toList());
        for (NavInstruction navinstruction : navInstructions) {
            String action = navinstruction.getAction();
            int value = navinstruction.getValue();
            if (compassDirectionStrings.contains(action)) {
                move(navinstruction);
            } else if (action.equals("F")) {
                String currentOrientation = position.getOrientation().toString();
                move(new NavInstruction(currentOrientation, value));
            } else if (List.of("L", "R").contains(action)) {
                turn(navinstruction);
            }
        }
    }


    public void moveWaypoint(NavInstruction navInstruction) {
        int currentEast = waypoint.getEast();
        int currentNorth = waypoint.getNorth();
        String action = navInstruction.getAction();
        switch (action) {
            case "E":
                waypoint.setEast(currentEast + navInstruction.getValue());
                break;
            case "N":
                waypoint.setNorth(currentNorth + navInstruction.getValue());
                break;
            case "W":
                waypoint.setEast(currentEast - navInstruction.getValue());
                break;
            case "S":
                waypoint.setNorth(currentNorth - navInstruction.getValue());
                break;
            default:
                break;
        }
    }


    public void turnWaypoint90right() {
        int posEast = waypoint.getEast();
        int posNorth = waypoint.getNorth();
        int newPosEast = 0;
        int newPosNorth = 0;
        newPosEast = posNorth;
        newPosNorth = -posEast;
        waypoint.setEast(newPosEast);
        waypoint.setNorth(newPosNorth);
    }


    public void turnWaypoint(NavInstruction navInstruction) {
        String action = navInstruction.getAction();
        if (!List.of("L", "R").contains(action)) return;
        int numberOfQuarterTurnsRight = 0;
        switch (action) {
            case "R":
                numberOfQuarterTurnsRight = navInstruction.getValue() / 90;
                break;
            case "L":
                numberOfQuarterTurnsRight = 4 - navInstruction.getValue() / 90;
                break;
            default:
                break;
        }
        for (int i = 0; i < numberOfQuarterTurnsRight; i++) {
            turnWaypoint90right();
        }
    }


    public void moveTowardWaypoint(NavInstruction navInstruction) {
        if (!navInstruction.getAction().equals("F")) return;

        int waypointEast = waypoint.getEast();
        int waypointNorth = waypoint.getNorth();
        int posEast = position.getEast();
        int posNorth = position.getNorth();
        int value = navInstruction.getValue();
        int newPosEast = posEast + waypointEast * value;
        int newPosNorth = posNorth + waypointNorth * value;
        position.setEast(newPosEast);
        position.setNorth(newPosNorth);
    }


    public void navigate2(List<NavInstruction> navInstructions) {
        List<String> compassDirectionStrings = Arrays.stream(CompassDirection.values())
                .map(e -> e.toString())
                .collect(Collectors.toList());
        for (NavInstruction navinstruction : navInstructions) {
            String action = navinstruction.getAction();
            int value = navinstruction.getValue();
            if (compassDirectionStrings.contains(action)) {
                moveWaypoint(navinstruction);
            } else if (action.equals("F")) {
                moveTowardWaypoint(navinstruction);
            } else if (List.of("L", "R").contains(action)) {
                turnWaypoint(navinstruction);
            }
        }

    }


}
