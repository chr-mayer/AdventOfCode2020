package day08;

import FileReader.FileReader;

import java.util.*;

public class InstructionsProcessor {
    private String pathString = "src/day08/input.txt";
    private FileReader fileReader = new FileReader();
    private LineParser lineParser = new LineParser();

    public List<Instruction> read() {
        List<String> lines = fileReader.read(pathString);
        List<Instruction> instructions = new ArrayList<>();
        for (String line:lines) {
            Instruction instruction = lineParser.parse(line);
            instructions.add(instruction);
        }
        return instructions;
    }


    public Map<Integer, Instruction> runGivenInstructions() {
        List<Instruction> instructions = read();
        return runInstructions(instructions);
    }



    public Map<Integer, Instruction> runInstructions(List<Instruction> instructions) {
        int size = instructions.size();
        int accumulator = 0;
        int pointer = 0;
        boolean goAhead = true;
        List<Integer> onceProcessedInstructionLines = new ArrayList<>();

        while (goAhead) {
            if (onceProcessedInstructionLines.contains(pointer)) {
                goAhead = false;
                break;
            }
            Instruction instruction = instructions.get(pointer);
            switch (instruction.getOperation()) {
                case "acc":
                    accumulator = accumulator + instruction.getParameter();
                    onceProcessedInstructionLines.add(pointer);
                    pointer++;
                    break;
                case "jmp":
                    onceProcessedInstructionLines.add(pointer);
                    pointer = pointer + instruction.getParameter();
                    break;
                case "nop":
                    onceProcessedInstructionLines.add(pointer);
                    pointer++;
                    break;
                default:
                    System.out.println("error in input file (instructions)");
                    goAhead = false;
                    break;
            }
            if (pointer == size) {
                goAhead = false;
                break;
            }
            if (pointer > size || pointer < 0) {
                goAhead = false;
                break;
            }

        }

        Map<Integer, Instruction> programRun = new HashMap<>();
        for (Integer line:onceProcessedInstructionLines) {
            programRun.put(line, instructions.get(line));
        }

        //System.out.println("part1:" + accumulator);

        return programRun;

    }



    public boolean terminatesCorrectly(List<Instruction> instructions) {
        int size = instructions.size();
        int accumulator = 0;
        int pointer = 0;
        boolean goAhead = true;
        List<Integer> onceProcessedInstructionLines = new ArrayList<>();
        boolean terminatesFine = false;

        while (goAhead) {
            if (onceProcessedInstructionLines.contains(pointer)) {
                goAhead = false;
                break;
            }
            Instruction instruction = instructions.get(pointer);
            switch (instruction.getOperation()) {
                case "acc":
                    accumulator = accumulator + instruction.getParameter();
                    onceProcessedInstructionLines.add(pointer);
                    pointer++;
                    break;
                case "jmp":
                    onceProcessedInstructionLines.add(pointer);
                    pointer = pointer + instruction.getParameter();
                    break;
                case "nop":
                    onceProcessedInstructionLines.add(pointer);
                    pointer++;
                    break;
                default:
                    System.out.println("error in input file (instructions)");
                    goAhead = false;
                    break;
            }
            if (pointer == size) {
                goAhead = false;
                terminatesFine = true;
                break;
            }
            if (pointer > size || pointer < 0) {
                goAhead = false;
                break;
            }

        }


        return terminatesFine;

    }



    public Optional<Integer> findError() {
        List<Instruction> instructions = read();
        if (terminatesCorrectly(instructions)) {
            return Optional.empty();
        }
        Map<Integer, Instruction> programRun = runGivenInstructions();

        for (Map.Entry<Integer, Instruction> entry : programRun.entrySet()) {
            if (entry.getValue().getOperation().equals("nop")) {
                instructions.get(entry.getKey()).setOperation("jmp");
                if (terminatesCorrectly(instructions)) {
                    int valueOfAcc = getValueOfAcc(runInstructions(instructions));
                    System.out.println("valueOfAcc with this corrected version: " + valueOfAcc);
                    return Optional.of(entry.getKey());
                } else {
                    instructions.get(entry.getKey()).setOperation("nop");
                }


            }
            if (entry.getValue().getOperation().equals("jmp")) {
                instructions.get(entry.getKey()).setOperation("nop");
                if (terminatesCorrectly(instructions)) {
                    int valueOfAcc = getValueOfAcc(runInstructions(instructions));
                    System.out.println("valueOfAcc with this corrected version: " + valueOfAcc);
                    return Optional.of(entry.getKey());
                } else {
                    instructions.get(entry.getKey()).setOperation("jmp");
                }


            }


        }

        return Optional.empty();
    }



















    public int getValueOfAcc(Map<Integer, Instruction> programRun) {
        int accumulator = 0;
        for (Map.Entry<Integer, Instruction> entry : programRun.entrySet()) {
            String operation = entry.getValue().getOperation();
            if (operation.equals("acc")) {
                accumulator = accumulator + entry.getValue().getParameter();
            }
        }
        return accumulator;
    }















}



























