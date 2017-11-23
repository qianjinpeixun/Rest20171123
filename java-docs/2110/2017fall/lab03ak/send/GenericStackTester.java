
/**
 * This class is a test class designed for CSCI 2110- Data Structures and
 * Algorithms Laboratory No. 3 Exercise 2
 * 
 */
public class GenericStackTester {

    public static void main(String[] args) {
        // create the first stack
        GenericStack<String> stack1 = new GenericStack<String>();
        // test Generic feature with String
        stack1.push("London");
        stack1.push("Paris");
        stack1.push("Halifax");
        // create the second stack
        GenericStack<Integer> stack2 = new GenericStack<Integer>();
        // test the Generic feature with Integer
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);

        // output these two stacks and check the result
        System.out.println(stack1);
        System.out.println(stack2);
    }
}
