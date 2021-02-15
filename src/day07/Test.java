package day07;

import java.util.*;

public class Test {
    private DataReader dataReader = new DataReader();
    private List<Bag> bagsList = dataReader.read();


    public void printbagsList() {
        for (Bag bag:bagsList) {
            System.out.println(bag);

        }
    }



}






















