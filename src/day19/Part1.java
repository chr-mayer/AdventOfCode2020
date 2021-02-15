package day19;

public class Part1 {
    public static void main(String[] args) {
        MessageValidator messageValidator = new MessageValidator();
        messageValidator.setPathString("src/day19/input-part2.txt");
/*        String s = messageValidator.getRegex();
        System.out.println(s);*/
        int count = messageValidator.countValidMessages();
        System.out.println(count);
    }
}
