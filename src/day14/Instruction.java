package day14;

import java.util.Objects;

public class Instruction {
    private String operation;
    private int address;
    private String value;

    public Instruction(String operation, int address, String value) {
        this.operation = operation;
        this.address = address;
        this.value = value;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instruction)) return false;
        Instruction that = (Instruction) o;
        return address == that.address && Objects.equals(operation, that.operation) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, address, value);
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "operation='" + operation + '\'' +
                ", address=" + address +
                ", value='" + value + '\'' +
                '}';
    }
}


