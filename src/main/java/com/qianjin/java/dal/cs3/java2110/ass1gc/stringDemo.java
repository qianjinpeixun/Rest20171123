/*Assignment 1 Question 2 CSCI 2110
  stringDemo.java is a test program 
    Oct 3st, 2017
   Yiping Liang B00744822
   This is entirely my own work. */

package com.qianjin.java.dal.cs3.java2110.ass1gc;


import java.util.Scanner;

public class stringDemo {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter String:");
		String a=kb.nextLine();
		System.out.print("Please enter SubString:");
		String b=kb.nextLine();
		StringMatch c= new StringMatch(a,b);
		c.check(a, b);
		

	}

}
