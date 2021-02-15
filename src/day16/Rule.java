package day16;


import java.util.List;

public class Rule {
    private String fieldName;
    private List<Range> ranges;

    public Rule(String fieldName, List<Range> ranges) {
        this.fieldName = fieldName;
        this.ranges = ranges;
    }

    public String getFieldName() {
        return fieldName;
    }

    public List<Range> getRanges() {
        return ranges;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "fieldName='" + fieldName + '\'' +
                ", ranges=" + ranges +
                '}';
    }
}
