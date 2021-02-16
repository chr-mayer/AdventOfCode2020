package day04;

public class Application {

    public static void main(String[] args) {

        DataReader2 dataReader2 = new DataReader2();
        int count = dataReader2.read();
        System.out.println("count: " + count);
    }
}
