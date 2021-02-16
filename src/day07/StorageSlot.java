package day07;

import java.util.Objects;

public class StorageSlot {
    private long count;
    private String color;

    public StorageSlot(long count, String color) {
        this.count = count;
        this.color = color;
    }

    public long getCount() {
        return count;
    }

    public String getColor() {
        return color;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StorageSlot)) return false;
        StorageSlot that = (StorageSlot) o;
        return count == that.count && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, color);
    }

    @Override
    public String toString() {
        return "{" +
                count +
                "," + color +
                '}';
    }
}
