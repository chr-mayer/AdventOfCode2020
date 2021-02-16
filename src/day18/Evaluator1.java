package day18;

import FileReader.FileReader;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Evaluator1 {
    private String  pathString = "src/day18/input.txt";
    private FileReader fileReader = new FileReader();


    public List<String> readInput() {
        return fileReader.read(pathString);
    }


    public Optional<String> reduceParenthesis(String line) {
        Pattern pattern = Pattern.compile("\\((\\d+ [+*] )+\\d+\\)");
        Matcher matcher = pattern.matcher(line);
        if (!matcher.find()) return Optional.empty();
        matcher.reset();
        List<String> results = matcher.results()
                .map(e -> e.group())
                .collect(Collectors.toList());
        for (String match:results) {
            long outcome = calculateSubExpression(match);
            String outcomeAsString = String.valueOf(outcome);
            line = line.replace(match, outcomeAsString);
        }
        return Optional.of(line);
    }


    public long calculateSubExpression(String expression) {
            String result = expression.replaceAll(" ", "")
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", "");
            int length = result.length();
            long outcome = 0L;
            String operator = "+";
            String number = "";
            for (int i = 0; i < length; i++) {
                if (!result.substring(i, i + 1).equals("+") && !result.substring(i, i + 1).equals("*")) {
                    number = number.concat(result.substring(i, i + 1));
                } else {
                    if (operator.equals("+")) outcome = outcome + Integer.parseInt(number);
                    else if (operator.equals("*")) outcome = outcome * Integer.parseInt(number);
                    number = "";
                    operator = result.substring(i, i + 1);
                }
                if (i == length-1) {
                    if (operator.equals("+")) outcome = outcome + Integer.parseInt(number);
                    else if (operator.equals("*")) outcome = outcome * Integer.parseInt(number);
                }
            }
            return outcome;
    }


    public long calculateLine(String line) {
        String reduced = line;
        while (reduceParenthesis(reduced).isPresent()) {
            reduced = reduceParenthesis(reduced).get();
        }
        return calculateSubExpression(reduced);
    }


    public long sumUpAllLines() {
        List<String> lines = readInput();
        long sum = 0L;
        for (String line:lines) {
            sum = sum + calculateLine(line);
        }
        return sum;
    }






























}
