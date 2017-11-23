package a1;

import java.util.Scanner;
public class StringMatch2 {
	public static void main(String[] args){
		Scanner keyboard  = new Scanner(System.in);
		
		System.out.print("Enter the filename to read from: ");
		String filename = keyboard.nextLine();
		Scanner file = new Scanner (filename);
		System.out.println("Enter a word: ");
		String s = keyboard.nextLine();
		StringBuilder f = new StringBuilder();
		while(file.hasNext()){
			f.append(file.nextLine());
		}
		String a = f.toString();
		long startTime, endTime, executionTime;
		startTime = System.currentTimeMillis();
		
		 
		int Time = 0;
		if(a.length()>=s.length()){
			for(int i=0;i<a.length()-s.length();i++){
				String string2=a.substring(i,i+ s.length());
				if(s.equals(string2))
					Time+=1;
			}
		System.out.println("Substring " + s + " was found in " + a +" "+ Time + " times");		
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println("Execution time is " + executionTime + " ms");//record the time
		}
	}
		}
