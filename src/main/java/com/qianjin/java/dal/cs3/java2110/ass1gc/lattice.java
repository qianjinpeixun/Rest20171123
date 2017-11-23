
/*Assignment 1 Question 2 CSCI 2110
 * 10.3 latticePath.java
 * Yiping Liang B00744822
 *  I asked basic idea from others and rest of is my work*/

package com.qianjin.java.dal.cs3.java2110.ass1gc;


import java.util.ArrayList;
import java.util.Scanner;

public class lattice {
	public static void main(String[] args) {

Scanner kb = new Scanner(System.in);
System.out.print("Enter the lattice size:");
int size=kb.nextInt();
long st, ex, et = 0;
st = System.currentTimeMillis();
ArrayList<String>path=lattice(size);
System.out.println("Path is "+path);
et = System.currentTimeMillis();
ex = et-st;
System.out.println("Execution time: "+ ex + "ms");

	}

public static ArrayList <String>lattice(int size){
	int pass=(int) Math.pow(2,Math.pow(2, size));//calculate the all the path
	ArrayList <String>path=new ArrayList<String>();
	int length=size*2;
	
	for(int i=0;i<pass;i++){
		StringBuilder a=new StringBuilder();
		String b=Integer.toBinaryString(i).replace("0", "N");//binary number if is 0 replace to N
		b=b.replace("1","E");
		while((a.length()+b.length())<length){//make every binary number has same size 101to00101
			a.append("N");//if less than length then fills up with 0
		}
		a.append(b);
		String c=a.toString();
		int n=c.length()-c.replace("N", "").length();
		int e=c.length()-c.replace("E", "").length();
		if(n==size&&e==size){
			path.add(c);
		}
		
	}
	return path;
	

}

}
