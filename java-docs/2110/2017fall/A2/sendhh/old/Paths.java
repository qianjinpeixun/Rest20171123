package a1;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
public class Paths{
	private static int n;
  public static void main (String []args){
   // ArrayList <String> array1 =new ArrayList<String>();
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter the value of n:");
     n = keyboard.nextInt(); 
    double path = (getFactorial(2*n))/(Math.pow(getFactorial(n),2));
    System.out.println("the number of path is"+path);
    //2print(array1);
    //array=getAll(n);
    //print(array);
    // print(getAll(n));
    long startTime, endTime, executionTime;
	startTime = System.currentTimeMillis();
	
    System.out.println(print(getArray(n)));
    System.out.println();
    endTime = System.currentTimeMillis();
	executionTime = endTime - startTime;
	System.out.println("Execution time is " + executionTime + " ms");

  }
  
    public static double getFactorial(double n){
    double sum=1;
    for (int i =1;i<=n;i++){
    sum=sum*i;
    }
    return sum;
    }
    
    public static ArrayList <String> getArray(double n){
    	ArrayList <String> array=new ArrayList<String>();
    String binary= null;
    NumberFormat a =NumberFormat.getInstance();
	a.setGroupingUsed(false);
	a.setMinimumIntegerDigits((int) (2*n));
    	for(int i =1; i <Math.pow(2,2*n);i++){
    		
    		binary = Integer.toBinaryString(i);//change to a binary
    		binary = a.format(Integer.parseInt(binary));
    		//System.out .println(binary);
    		
    		array.add(binary);
    		
    	}
		return array;
    }
    public static boolean rightPath(String s){// check the path 
    	
    	int numofone = 0;//record the time of occurrence number 1
    		for(int j=0; j<s.length(); j++){
    			if(s.charAt(j)=='1')
    			numofone++;
    		}
    		if (numofone==n){
    		return true;
    		}
    		else
			return false;
    }
    public static ArrayList<String> print(ArrayList<String> a){
    	String s= "";
    	ArrayList <String> list=new ArrayList<String>();
    	for(int i=0;i<a.size();i++){
    		s= a.get(i);
    	    if(rightPath(s)==true){
    	    	s = s.replaceAll("0","N");//change 0 to n and change 1 to E
        		s = s.replaceAll("1","E");
    	    	list.add(s);
    	    }
    	 }
		 return list;
    }
   
		

     
}
                              
       
       
