package day16;

public class Range {
    private int min;
    private int max;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "Range{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}
