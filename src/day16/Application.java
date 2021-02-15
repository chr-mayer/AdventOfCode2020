package day16;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("str1", "str2", "str3"));
        System.out.println(list);
        String toRemove = "str9";
        list.remove(toRemove);
        System.out.println(list);



    }



}
