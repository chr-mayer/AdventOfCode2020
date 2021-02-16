package day07;

import java.util.ArrayList;
import java.util.List;

public class LineParser {
    public Bag parse(String line) {
        List<String> splitted1 = List.of(line.split(" bags contain "));
        String bagColor = splitted1.get(0);

        List<StorageSlot> storageSlots = new ArrayList<>();
        if (!splitted1.get(1).contains("no other bags.")) {

            List<String> listOfStorageSlotStrings = List.of(splitted1.get(1).split(", "));
            for (String storageSlotString : listOfStorageSlotStrings) {
                List<String> cols = List.of(storageSlotString.split(" ", 2));
                int count = 0;
                try {
                    count = Integer.parseInt(cols.get(0));
                    //System.out.println(count);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                String color = cols.get(1).replaceAll(" bag[s]{0,1}.{0,1}", "");
                //System.out.println(color);
                storageSlots.add(new StorageSlot(count, color));
            }

        }
        return new Bag(bagColor, storageSlots);


    }


}
