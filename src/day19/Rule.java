package day19;

import java.util.List;

public class Rule {
    private String name;
    private List<String> patterns;

    public Rule(String name, List<String> patterns) {
        this.name = name;
        this.patterns = patterns;
    }

    public String getName() {
        return name;
    }

    public List<String> getPatterns() {
        return patterns;
    }

}
