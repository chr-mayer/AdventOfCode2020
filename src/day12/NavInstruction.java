package day12;

public class NavInstruction {
    private String action;
    private int value;

    public NavInstruction(String action, int value) {
        this.action = action;
        this.value = value;
    }

    public String getAction() {
        return action;
    }

    public int getValue() {
        return value;
    }


}
