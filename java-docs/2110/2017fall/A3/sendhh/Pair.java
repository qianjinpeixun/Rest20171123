

//This is a class in order to store the value and probability of each character
public class Pair implements Comparable<Pair> {

    private char value;
    private double prob;
    private int occurence;
    private String code;

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

    public int getOccurence() {
        return occurence;
    }

    public void setOccurence(int occurence) {
        this.occurence = occurence;
    }

    public int compareTo(Pair o) {
        if (this.prob < o.getProb())
            return -1;
        if (this.prob > o.getProb())
            return 1;
        return 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String toString() {
        return "P(" + value + "," + prob  + ")";
    }
    
    

}
