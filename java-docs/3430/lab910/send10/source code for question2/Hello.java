import java.util.Scanner;

public class Hello {

    private static native int operate(byte[] sa, byte[] sb, byte[] sc);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter three integers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if(b==0){
            System.out.println("The second number should not be zero!");
        }else{
            byte[] a1=String.valueOf(a).getBytes();
            byte[] b1=String.valueOf(b).getBytes();
            byte[] c1=String.valueOf(c).getBytes();
            
            int result = 0;
            result = operate(a1, b1, c1);
            System.out.println("The result(A/B-C) is: " + String.valueOf(result));
        }
        scanner.close();
    }

    static {
        System.loadLibrary("helloc");
    }

}
