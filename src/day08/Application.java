package day08;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        InstructionsProcessor instructionsProcessor = new InstructionsProcessor();
        Map<Integer, Instruction> run = instructionsProcessor.runGivenInstructions();
/*        System.out.println("-------");
        System.out.println(run.size());
        System.out.println(run);*/
        int valueOfAcc = instructionsProcessor.getValueOfAcc(run);
        System.out.println("valueOfAcc: " + valueOfAcc);

        System.out.println("-------");
        List<Instruction> instructionsFromFile = instructionsProcessor.read();
        boolean terminatesCorrectly = instructionsProcessor.terminatesCorrectly(instructionsFromFile);
        System.out.println("terminatesCorrectly: " +terminatesCorrectly);

        System.out.println();
        System.out.println();

        Optional<Integer> error = instructionsProcessor.findError();
        if (error.isEmpty()) {
            System.out.println("no error found");
        } else {
            System.out.println("error found in line " + error.get());
        }


    }
}
