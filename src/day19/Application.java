package day19;

public class Application {
    public static void main(String[] args) {
        MessageValidator messageValidator = new MessageValidator();
        messageValidator.setPathString("src/day19/input-part2.txt");
        String regexPart2 = messageValidator.getRegexPart2();
        System.out.println(regexPart2);
        int count2 = messageValidator.countValidMessages2();
        System.out.println(count2);


    }
}

