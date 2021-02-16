package day16;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TicketChecker {
    //private String pathString = "src/day16/sample_input2.txt";
    private String pathString = "src/day16/input.txt";
    private FileReader fileReader = new FileReader();

    public List<Rule> readRules() {
        List<Rule> rules = new ArrayList<>();
        List<String> inputLines = fileReader.read(pathString);
        int lastLine = 0;
        for (int i = 0; i < inputLines.size(); i++) {
            if (inputLines.get(i).equals("your ticket:") && inputLines.get(i - 1).isEmpty()) {
                lastLine = i - 1;
                break;
            }
        }
        for (int i = 0; i < lastLine; i++) {
            Rule rule = parseRule(inputLines.get(i));
            rules.add(rule);
        }
        return rules;
    }


    public Rule parseRule(String line) {
        List<String> split1 = List.of(line.split(": "));
        String fieldName = split1.get(0);
        List<String> rangeStrings = List.of(split1.get(1).split(" or "));
        List<Range> ranges = new ArrayList<>();
        for (String rangeString : rangeStrings) {
            List<String> rangeLimits = List.of(rangeString.split("-"));
            int begin = Integer.parseInt(rangeLimits.get(0));
            int end = Integer.parseInt(rangeLimits.get(1));
            ranges.add(new Range(begin, end));
        }
        return new Rule(fieldName, ranges);
    }


    public List<Integer> readMyTicket() {
        List<String> inputLines = fileReader.read(pathString);
        String myTicketString = "";
        for (int i = 0; i < inputLines.size(); i++) {
            if (inputLines.get(i).equals("your ticket:")) {
                myTicketString = inputLines.get(i + 1);
                break;
            }
        }
        return List.of(myTicketString.split(",")).stream()
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());
    }

    public List<List<Integer>> readNearbyTickets() {
        List<List<Integer>> nearByTickets = new ArrayList<>();
        List<String> inputLines = fileReader.read(pathString);
        int start = 0;
        for (int i = 0; i < inputLines.size(); i++) {
            if (inputLines.get(i).equals("nearby tickets:")) {
                start = i + 1;
            }
        }
        for (int i = start; i < inputLines.size(); i++) {
            List<Integer> ticket = Arrays.stream(inputLines.get(i).split(","))
                    .map(e -> Integer.parseInt(e))
                    .collect(Collectors.toList());
            nearByTickets.add(ticket);
        }
        return nearByTickets;
    }


    public boolean isInvalidForAllRules(int value) {
        List<Rule> rules = this.readRules();
        boolean result = true;
        for (Rule rule : rules) {
            List<Range> ranges = rule.getRanges();
            for (Range range : ranges) {
                if (value < range.getMin() || value > range.getMax()) {
                    result = result && true;
                } else {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }


    public int getTicketScanningErrorRate() {
        int errorRate = 0;
        List<List<Integer>> nearbyTickets = this.readNearbyTickets();
        for (List<Integer> ticket : nearbyTickets) {
            for (Integer number : ticket) {
                if (isInvalidForAllRules(number)) {
                    errorRate = errorRate + number;
                }
            }
        }
        return errorRate;
    }


    public List<List<Integer>> getNearbyValidTickets() {
        List<List<Integer>> nearbyValidTickets = new ArrayList<>();
        List<List<Integer>> nearbyTickets = readNearbyTickets();
/*        List<Integer> myTicket = readMyTicket();
        nearbyTickets.add(myTicket);*/
        for (List<Integer> ticket : nearbyTickets) {
            boolean hasAnInvalidValue = false;
            for (Integer value : ticket) {
                if (isInvalidForAllRules(value)) {
                    hasAnInvalidValue = hasAnInvalidValue || isInvalidForAllRules(value);
                    break;
                }
            }
            if (!hasAnInvalidValue) {
                nearbyValidTickets.add(ticket);
            }
        }
        return nearbyValidTickets;
    }


    public boolean isInvalidColumnForRule(int columnIndex, int ruleIndex) {
        List<List<Integer>> nearbyValidTickets = getNearbyValidTickets();
        List<Rule> rules = readRules();
        Rule rule = rules.get(ruleIndex);
        List<Integer> column = new ArrayList<>();
        for (List<Integer> ticket : nearbyValidTickets) {
            column.add(ticket.get(columnIndex));
        }
        for (Integer value : column) {
            boolean isInvalid = true;
            for (Range range : rule.getRanges()) {
                isInvalid = isInvalid && (value < range.getMin() || value > range.getMax());
            }
            if (isInvalid) return isInvalid;
        }
        return false;
    }


    public List<List<String>> checkNearbyTicketsAgainstAllRules() {
        List<String> fieldNames = readRules().stream()
                .map(e -> e.getFieldName())
                .collect(Collectors.toList());

        int numberOfColumns = fieldNames.size();
        int numberOfRules = numberOfColumns;

        List<List<String>> candidatesForTicketColumns = new ArrayList<>();
        for (int i = 0; i < numberOfColumns; i++) {
            candidatesForTicketColumns.add(new ArrayList<>(fieldNames));
        }
        //System.out.println(candidatesForTicketColumns);

        for (int i = 0; i < numberOfColumns; i++) {
            for (int j = 0; j < numberOfRules; j++) {
                if (isInvalidColumnForRule(i, j)) {
                    String impossibleField = fieldNames.get(j);
                    candidatesForTicketColumns.get(i).remove(impossibleField);
                }
            }
        }
        return candidatesForTicketColumns;
    }


    public void reduceOnce(List<List<String>> candidatesForTicketColumns) {
        for (int i = 0; i < candidatesForTicketColumns.size(); i++) {
            if (candidatesForTicketColumns.get(i).size() == 1) {
                String s = candidatesForTicketColumns.get(i).get(0);
                for (List<String> candidates : candidatesForTicketColumns) {
                    if (candidates.size() != 1) {
                        candidates.remove(s);
                    }
                }
            }
        }
    }


    public List<String> reduce(List<List<String>> candidatesForTicketColumns) {
        for (int i = 0; i < candidatesForTicketColumns.size(); i++) {
            reduceOnce(candidatesForTicketColumns);
        }
        //System.out.println(candidatesForTicketColumns);
        return candidatesForTicketColumns.stream()
                .map(e -> e.get(0))
                .collect(Collectors.toList());
    }

    public long getPuzzleAnswer(List<String> fieldNames) {
        List<Integer> myTicket = readMyTicket();
        long answer = 1L;
        for (int i = 0; i < fieldNames.size(); i++) {
            if (fieldNames.get(i).startsWith("departure")) {
                answer = answer * myTicket.get(i);
            }
        }
        return answer;
    }















}






