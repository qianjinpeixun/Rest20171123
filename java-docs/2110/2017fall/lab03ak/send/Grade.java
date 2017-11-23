
public class Grade<T> {
    private T value;

    public Grade(T entry) {
        value = entry;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T entry) {
        value = entry;
    }

    public String toString() {
        return "" + value;
    }

    public static void main(String[] args) {
        Grade<String> m1 = new Grade<String>("ABC");
        Grade<Integer> m2 = new Grade<Integer>(100);
        System.out.println(m1);
        System.out.println(m2);
        m1.setValue("A-");
        m2.setValue(-75);
        System.out.println(m1);
        System.out.println(m2);
    }
}
