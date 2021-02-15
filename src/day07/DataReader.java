package day07;

import FileReader.FileReader;

import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private String pathString = "src/day07/input.txt";
    private FileReader fileReader = new FileReader();
    private LineParser lineParser = new LineParser();

    public List<Bag> read() {
        List<String> lines = fileReader.read(pathString);
        List<Bag> bags = new ArrayList<>();
        for (String line:lines) {
            Bag bag = lineParser.parse(line);
            bags.add(bag);
        }
        return bags;
    }


}
