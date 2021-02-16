package day07;

import java.util.List;
import java.util.Objects;

public class Bag {
    private String color;
    private List<StorageSlot> storageSlots;

    public Bag(String color, List<StorageSlot> storageSlots) {
        this.color = color;
        this.storageSlots = storageSlots;
    }

    public String getColor() {
        return color;
    }

    public List<StorageSlot> getStorageSlots() {
        return storageSlots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bag)) return false;
        Bag bag = (Bag) o;
        return Objects.equals(color, bag.color) && Objects.equals(storageSlots, bag.storageSlots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, storageSlots);
    }

    @Override
    public String toString() {
        return "Bag{" +
                "color='" + color + '\'' +
                ", storageSlots=" + storageSlots +
                '}';
    }
}
