package day14;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Emulator {
    //private String pathString = "src/day14/sample_input2.txt";
    private String pathString = "src/day14/input.txt";
    private FileReader fileReader = new FileReader();

    private String bitmask;
    private Map<Long, Long> memory = new HashMap<>();

    public String getBitmask() {
        return bitmask;
    }

    public void setBitmask(String bitmask) {
        this.bitmask = bitmask;
    }

    public Map<Long, Long> getMemory() {
        return memory;
    }

    public void setMemory(Map<Long, Long> memory) {
        this.memory = memory;
    }


    public List<Instruction> readInput() {
        List<String> lines = fileReader.read(pathString);
        List<Instruction> instructions = new ArrayList<>();
        for (String line : lines) {
            Instruction instruction = parseLine(line);
            instructions.add(instruction);
        }
        return instructions;
    }


    public Instruction parseLine(String line) {
        List<String> columns = List.of(line.split(" = "));
        String operation = "";
        int address = 0;
        String value = columns.get(1);
        if (columns.get(0).equals("mask")) {
            operation = "mask";
        } else if (columns.get(0).startsWith("mem")) {
            operation = "mem";
            String addressString = columns.get(0).split("\\[")[1].replaceAll("]", "");
            address = Integer.parseInt(addressString);
        }
        return new Instruction(operation, address, value);
    }


    public long applyBitmask1(String bitmask, int number) {
        String binaryNumber = Integer.toBinaryString(number);
        List<String> bitmaskAsList = new ArrayList<>(List.of(bitmask.split("")));
        List<String> binaryNumberAsList = new ArrayList<>(List.of(binaryNumber.split("")));
        int size = binaryNumberAsList.size();

        for (int i = 0; i < 36 - size; i++) {
            binaryNumberAsList.add(0, "0");
        }

        for (int i = 0; i < binaryNumberAsList.size(); i++) {
            switch (bitmaskAsList.get(i)) {
                case "0":
                    binaryNumberAsList.set(i, "0");
                    break;
                case "1":
                    binaryNumberAsList.set(i, "1");
                    break;
                case "X":

                    break;
                default:
                    break;
            }
        }
        String binaryNumberMasked = binaryNumberAsList.stream()
                .collect(Collectors.joining());
        long dec = Long.parseUnsignedLong(binaryNumberMasked, 2);
        return dec;
    }


    public long processInstructions1() {
        List<Instruction> instructions = readInput();
        for (Instruction instruction : instructions) {
            switch (instruction.getOperation()) {
                case "mask":
                    setBitmask(instruction.getValue());
                    break;
                case "mem":
                    int value = 0;
                    try {
                        value = Integer.parseInt(instruction.getValue());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                    long maskedValue = applyBitmask1(getBitmask(), value);
                    long address = instruction.getAddress();
                    getMemory().put(address, maskedValue);
                    break;
                default:
                    break;
            }
        }
        return memory.values().stream()
                .reduce(Long::sum)
                .get();
    }



    public void applyBitmaskAndWriteToMem(long address, long value) {
        String bitmask = this.getBitmask();
        List<String> bitmaskAsList = new ArrayList<>(List.of(bitmask.split("")));
        String addressBin = Long.toBinaryString(address);
        List<String> addressBinaryAsList = new ArrayList<>(List.of(addressBin.split("")));
        int size = addressBinaryAsList.size();
        for (int i = 0; i < 36 - size; i++) {
            addressBinaryAsList.add(0, "0");
        }

        List<Integer> positionsOfFloatingBits = new ArrayList<>();
        for (int i = 0; i < addressBinaryAsList.size(); i++) {
            if (bitmaskAsList.get(i).equals("1")) {
                    addressBinaryAsList.set(i, "1");
            } else if (bitmaskAsList.get(i).equals("X")) {
                positionsOfFloatingBits.add(i);
            }
        }
       /* System.out.println("positionsOfFloatingBits: " + positionsOfFloatingBits);*/

        int numberOfFloatingBits = positionsOfFloatingBits.size();
        /*System.out.println("numberOfFloatingBits: " + numberOfFloatingBits);*/
        for (long i = 0; i < Math.pow(2, numberOfFloatingBits); i++) {
            List<String> variation = new ArrayList<>(List.of(Long.toBinaryString(i).split("")));
            int sizeOfVariation = variation.size();
            for (int j = 0; j < numberOfFloatingBits - sizeOfVariation; j++) {
                variation.add(0, "0");
            }



            /*System.out.println("variation: " + variation);*/
            List<String> newAddressBinaryAsList = new ArrayList<>(addressBinaryAsList);
            /*System.out.println("addressBinaryAsList: " + addressBinaryAsList);*/
            for (int j = 0; j < positionsOfFloatingBits.size(); j++) {

/*                System.out.println("positionsOfFloatingBits.get(" + j + "): " + positionsOfFloatingBits.get(j));
                System.out.println("variation.get(" + j + "): " + variation.get(j));
                System.out.println("---");*/

                newAddressBinaryAsList.set(positionsOfFloatingBits.get(j), variation.get(j));
                String newAddressBinary = newAddressBinaryAsList.stream()
                        .collect(Collectors.joining());
                long newAddress = Long.parseUnsignedLong(newAddressBinary, 2);
                this.memory.put(newAddress, value);
            }

        }










    }



    public long processInstructions2() {
        List<Instruction> instructions = readInput();
        for (Instruction instruction : instructions) {
            switch (instruction.getOperation()) {
                case "mask":
                    setBitmask(instruction.getValue());
                    break;
                case "mem":
                    long address = instruction.getAddress();
                    long value = 0;
                    try {
                        value = Long.parseLong(instruction.getValue());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    applyBitmaskAndWriteToMem(address, value);
                    break;
                default:
                    break;
            }
        }
        return memory.values().stream()
                .reduce(Long::sum)
                .get();
    }



}
