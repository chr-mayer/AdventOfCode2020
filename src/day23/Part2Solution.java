package day23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part2Solution {

    public Object getPart2Solution() {
        final List<Integer> cups = getInput();
        final int max = 1000000;

        final Cup[] cupMap = new Cup[max + 1];

        Cup head = new Cup(cups.get(0));
        cupMap[head.value] = head;
        Cup tail = head;

        for (int i = 1; i < cups.size(); i++) {
            final Cup c = new Cup(cups.get(i));
            cupMap[c.value] = c;
            c.next = head;
            tail.next = c;
            tail = c;
        }

        for (int i = Collections.max(cups) + 1; i <= max; i++) {
            final Cup c = new Cup(i);
            cupMap[c.value] = c;
            c.next = head;
            tail.next = c;
            tail = c;
        }

        for (int i = 0; i < 10000000; i++) {
            final Cup current = head;
            final Cup c1 = current.next;
            final Cup c3 = c1.next.next;

            head.next = c3.next;

            int targetIndex = current.value == 1 ? max : current.value - 1;
            while (targetIndex == c1.value || targetIndex == c1.next.value || targetIndex == c3.value) {
                targetIndex--;
                targetIndex = targetIndex < 1 ? max : targetIndex;
            }

            final Cup target = cupMap[targetIndex];

            c3.next = target.next;
            target.next = c1;
            tail = current;
            head = current.next;
        }

        final Cup one = cupMap[1];
        return (long)one.next.value * one.next.next.value;
    }

    private List<Integer> getInput() {
        final String input = "653427918";
        final List<Integer> cups = new ArrayList<>();
        for (String c : input.split("")) {
            cups.add(Integer.parseInt(c));
        }

        return cups;
    }

    private static class Cup {
        public final int value;
        public Cup next;

        public Cup(int value) {
            this.value = value;
        }
    }
    
    
    
    
    
    
    
    
    

}
