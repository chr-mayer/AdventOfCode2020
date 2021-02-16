package day18;

import FileReader.FileReader;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Evaluator2 {
    private String pathString = "src/day18/input.txt";
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
        for (String match : results) {
            long outcome = calculateSubExpression(match);
            String outcomeAsString = String.valueOf(outcome);
            line = line.replace(match, outcomeAsString);
        }
        return Optional.of(line);
    }


    public Optional<String> reduceSums(String line) {
        Pattern pattern = Pattern.compile("(\\d+[+])+\\d+");
        Matcher matcher = pattern.matcher(line);
        if (!matcher.find()) return Optional.empty();
        matcher.reset();
        List<String> results = matcher.results()
                .map(e -> e.group())
                .collect(Collectors.toList());
        for (String match : results) {
            Long outcome = Arrays.stream(match.split("\\+"))
                    .map(e -> Long.parseLong(e))
                    .reduce(0L, Long::sum);
            String outcomeAsString = String.valueOf(outcome);
            line = line.replace(match, outcomeAsString);
        }
        return Optional.of(line);
    }


    public long calculateSubExpression(String expression) {
        String result = expression.replaceAll(" ", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "");
        if (reduceSums(result).isPresent()) {
            result = reduceSums(result).get();
        }
        Long product = Arrays.stream(result.split("\\*"))
                .map(e -> Long.parseLong(e))
                .reduce(1L, (a, b) -> a * b);
        return product;
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
        for (String line : lines) {
            sum = sum + calculateLine(line);
        }
        return sum;
    }


}
