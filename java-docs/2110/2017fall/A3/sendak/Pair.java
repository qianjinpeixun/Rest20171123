
/*
 * This class is designed as a class which can defines the symbol and its
 * probability as an object.
 */
public class Pair {

    // the encodeded huffman code
    private String prefix;
    // the original character
    private char value;
    // the probability
    private double prob;
    // the count of occurrence
    private int count;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Pair(char value) {
        this.value = value;
        count = 0;
        prob = 0.0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    @Override
    public String toString() {
        return "Pair [prefix=" + prefix + ", value=" + value + ", prob=" + prob + ", count=" + count + "]";
    }

}
