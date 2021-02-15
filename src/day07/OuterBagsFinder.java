package day07;

import java.util.*;

public class OuterBagsFinder {
    private String myBagColor = "shiny gold";
    private DataReader dataReader = new DataReader();
    private List<Bag> bagsList = dataReader.read();
    private Set<Bag> bags = new HashSet<Bag>(bagsList);


    public void printbagMap() {
        Map<String, List<StorageSlot>> bagsMap = new HashMap();
        for (Bag bag : bagsList) {
            bagsMap.put(bag.getColor(), bag.getStorageSlots());
        }
        for (Map.Entry<String, List<StorageSlot>> entry : bagsMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public void printbagsList() {
        for (Bag bag : bagsList) {
            System.out.println(bag);
        }
    }


    public Set<String> find() {
        return new HashSet<>();
    }

    public int countOuterBags() {
        return find().size();
    }


    public long countBagsToBuy() {
        Map<String, List<StorageSlot>> bagsMap = new HashMap();
        for (Bag bag : bagsList) {
            bagsMap.put(bag.getColor(), bag.getStorageSlots());
        }


        List<StorageSlot> storageSlots1 = bagsMap.get(myBagColor);
        long count = 0;

        System.out.println("-----------0-----------");
        System.out.println(storageSlots1);
        System.out.println("-----------0-----------");
        System.out.println();
        System.out.println();
/*        for (Map.Entry<String, List<StorageSlot>> entry : bagsMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("-----------0-----------");*/

        int k = 1;

        while (true) {
            List<StorageSlot> storageSlots2 = new ArrayList<>();
            long sum = storageSlots1.stream()
                    .map(e -> e.getCount())
                    .reduce(0L, (a, b) -> a + b);
            count = count + sum;
            System.out.println("sum= " + sum);
            System.out.println(storageSlots1);
            for (StorageSlot storageSlot : storageSlots1) {
                if (bagsMap.get(storageSlot.getColor()).isEmpty()) {
                    //storageSlots2.add(new StorageSlot(storageSlot.getCount(), storageSlot.getColor()));
/*                    System.out.println("-----------" + k + "\"-----------\"");
                    System.out.println(storageSlots2);
                    System.out.println("-----------" + k + "\"-----------\"");*/
                    continue;
                } else {
                    long c = storageSlot.getCount();
                    //System.out.println("c= " + c);

                    List<StorageSlot> storageSlotsInner = new ArrayList<>();
                    for (StorageSlot slot : bagsMap.get(storageSlot.getColor())) {
                        storageSlotsInner.add(new StorageSlot(slot.getCount(), slot.getColor()));
                    }

                    //System.out.println("bagsMap.get(" + storageSlot.getColor() + "): " + storageSlotsInner);


                    for (StorageSlot innerSlot : storageSlotsInner) {
                        long newCount = innerSlot.getCount() * c;
                        innerSlot.setCount(newCount);
                    }

                    storageSlots2.addAll(storageSlotsInner);
                    //System.out.println("storageSlots2.addAll(storageSlotsInner): " + storageSlotsInner);

                    //System.out.println("-----------" + k + "\"-----------\"");
/*                    System.out.println(storageSlots2);
                    System.out.println("-----------" + k + "\"-----------\"");*/
                }
            }

            System.out.println(storageSlots2);
            System.out.println("-----------" + k + "\"-----------\"");


            if (storageSlots2.equals(storageSlots1)) {
                break;
            } else {
                storageSlots1 = storageSlots2;

            }
            k++;
            System.out.println();
            System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
        }
        System.out.println();
        System.out.println("+++++++++++");
        System.out.println(storageSlots1);
        System.out.println("+++++++++++");

/*        count = count + storageSlots1.stream()
                .map(e -> e.getCount())
                .reduce(0L, (a, b) -> a + b);*/

        return count;
    }


}






















