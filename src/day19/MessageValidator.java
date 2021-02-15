package day19;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MessageValidator {
    private String pathString = "src/day19/input1b.txt";

    public void setPathString(String pathString) {
        this.pathString = pathString;
    }

    private FileReader fileReader = new FileReader();


    public List<String> readMessages() {
        List<String> messages = new ArrayList<>();
        List<String> lines = fileReader.read(pathString);
        return lines.stream()
                .filter(e -> (e.startsWith("a") || e.startsWith("b")))
                .collect(Collectors.toList());
    }


    public Map<String, String> readRules() {
        Map<String, String> rules = new HashMap<>();

        List<String> lines = fileReader.read(pathString);
        int i = 0;
        Pattern pattern = Pattern.compile("^\\d+:.*");
        while (pattern.matcher(lines.get(i)).matches()) {
            List<String> patterns = new ArrayList<>();
            String[] cols = lines.get(i).split(": ");
            rules.put(cols[0], cols[1]);
            i++;
        }
        return rules;
    }


    public String getRegex() {
        Map<String, String> rules = readRules();
        String start = rules.get("0");
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        String result = start;
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()) {
            matcher.reset();
            List<String> matches = matcher.results()
                    .map(e -> e.group())
                    .collect(Collectors.toList());

            for (String match : matches) {
                String substitution = rules.get(match);
                if (substitution.equals("\"a\"")) substitution = "a";
                else if (substitution.equals("\"b\"")) substitution = "b";
                else substitution = "(" + substitution + ")";
                result = result.replaceAll("\\b" + match + "\\b", substitution);
            }
            matcher = pattern.matcher(result);

        }
        result = result.replace(" ", "");
        return result;
    }


    public int countValidMessages() {
        List<String> messages = readMessages();
        String regex = getRegex();
        int counter = 0;
        Pattern pattern = Pattern.compile("^" + regex + "$");

        for (String message: messages) {
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) counter++;
        }

        return counter;

    }


    public String getRegexPart2() {
        Map<String, String> rules = readRules();
        String start = rules.get("0");
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        String result = start;
        Matcher matcher = pattern.matcher(result);

        int i = 0;

        while (matcher.find()) {
            matcher.reset();
            List<String> matches = matcher.results()
                    .map(e -> e.group())
                    .collect(Collectors.toList());

            for (String match : matches) {
                String substitution = rules.get(match);
                if (substitution.equals("\"a\"")) substitution = "a";
                else if (substitution.equals("\"b\"")) substitution = "b";
                else substitution = "(" + substitution + ")";
                result = result.replaceAll("\\b" + match + "\\b", substitution);
            }
            matcher = pattern.matcher(result);

            i++;
            if (i == 20) break;


        }



        System.out.println("+++++++++++++++");
        System.out.println(result);
        result = result.replace(" ", "");
        return result;
    }


    public int countValidMessages2() {
        List<String> messages = readMessages();
        String regex = getRegexPart2();
        int counter = 0;
        Pattern pattern = Pattern.compile("^" + regex + "$");

        for (String message: messages) {
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) counter++;
        }

        return counter;

    }







}
