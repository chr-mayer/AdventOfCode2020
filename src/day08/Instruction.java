package day08;

import java.util.Objects;

public class Instruction {
    private String operation;
    private int parameter;

    public Instruction(String operation, int parameter) {
        this.operation = operation;
        this.parameter = parameter;
    }

    public String getOperation() {
        return operation;
    }

    public int getParameter() {
        return parameter;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setParameter(int parameter) {
        this.parameter = parameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instruction)) return false;
        Instruction that = (Instruction) o;
        return parameter == that.parameter && Objects.equals(operation, that.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, parameter);
    }

    @Override
    public String toString() {
        return "{" + operation +
                ", " + parameter +
                '}';
    }


}
