package day07;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataReaderTest {
    DataReader dataReader = new DataReader();

    @Test
    void read() {
        List<Bag> lines = dataReader.read();

        Bag bag0Expected = new Bag("dotted salmon",
                List.of(new StorageSlot(2, "dark lavender"),
                        new StorageSlot(1, "muted red"),
                        new StorageSlot(1, "vibrant magenta")));
        Bag bag0Resulting = lines.get(0);

        Bag bag19Expected = new Bag("dotted lavender",
                List.of(new StorageSlot(1, "striped white"),
                        new StorageSlot(5, "dotted coral"),
                        new StorageSlot(3, "striped orange"),
                        new StorageSlot(1, "dotted gray")));
        Bag bag19Resulting = lines.get(19);

        Bag bag172Expected = new Bag("striped bronze",
                List.of(new StorageSlot(3, "striped white"),
                        new StorageSlot(5, "striped orange")));
        Bag bag172Resulting = lines.get(172);

        Bag bag593Expected = new Bag("plaid gold",
                List.of(new StorageSlot(4, "dark lime"),
                        new StorageSlot(3, "drab aqua"),
                        new StorageSlot(3, "dim white"),
                        new StorageSlot(2, "mirrored brown")));
        Bag bag593Resulting = lines.get(593);


        assertEquals(bag0Expected, bag0Resulting);
        assertEquals(bag19Expected, bag19Resulting);
        assertEquals(bag172Expected, bag172Resulting);
        assertEquals(bag593Expected, bag593Resulting);


    }
}