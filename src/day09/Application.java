package day09;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        RuleChecker1 ruleChecker1 = new RuleChecker1();
        Optional<Long> firstWrongNumber = ruleChecker1.check();
        if (firstWrongNumber.isEmpty()) {
            System.out.println("alle numbers are ok");
        } else {
            System.out.println("firstWrongNumber: " + firstWrongNumber.get());
        }

        Optional<List<Long>> summands = ruleChecker1.findSummands(firstWrongNumber.get());
        if (summands.isEmpty()) {
            System.out.println("no summands found");
        } else {
            System.out.println(summands.get() + " sums up to " + firstWrongNumber.get());
            Collections.sort(summands.get());
            long encryptionWeakness = summands.get().get(0) + summands.get().get(summands.get().size()-1);
            System.out.println("encryptionWeakness: " + encryptionWeakness);
        }

        Collections.sort(summands.get());




    }
}
