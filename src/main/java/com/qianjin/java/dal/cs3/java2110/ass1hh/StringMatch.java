package com.qianjin.java.dal.cs3.java2110.ass1hh;

import java.util.Scanner;
public class StringMatch {
	public static void main(String[] args){
		Scanner keyboard  = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String s1 = keyboard.nextLine();
		System.out.println("Enter a substring: ");
		String s2 = keyboard.nextLine();
		long startTime, endTime, executionTime;
		startTime = System.currentTimeMillis();
		
		 
		int Time = 0;
		if(s1.length()>=s2.length()){
			for(int i=0;i<s1.length()-s2.length();i++){
				String string2=s1.substring(i,i+ s2.length());
				if(s2.equals(string2))
					Time+=1;
			}
			System.out.println("Substring " + s2 + " was found in " + s1 +" "+ Time + " times");		
			endTime = System.currentTimeMillis();
			executionTime = endTime - startTime;
			System.out.println("Execution time is " + executionTime + " ms");
		}
		else
			System.out.println("No matches - substring wonderful was not found in wonder");//record the time

	}
}