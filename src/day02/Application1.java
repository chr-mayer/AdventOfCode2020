package day02;

public class Application1 {
    public static void main(String[] args) {
        ValidPasswordsCounter1 validPasswordsCounter1 = new ValidPasswordsCounter1();
        int numberOfValidPasswords = validPasswordsCounter1.count();
        System.out.println(numberOfValidPasswords);
    }
}
