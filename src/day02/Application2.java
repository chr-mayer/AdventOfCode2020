package day02;

public class Application2 {
    public static void main(String[] args) {
        ValidPasswordsCounter2 validPasswordsCounter2 = new ValidPasswordsCounter2();
        int numberOfValidPasswords = validPasswordsCounter2.count();
        System.out.println(numberOfValidPasswords);
    }
}
