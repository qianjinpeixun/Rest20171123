/*Assignment 1 Question 2 CSCI 2110
 * 10.3 DNADemo.java
 * Yiping Liang B00744822
 *  This is entirely my own work. */
package com.qianjin.java.dal.cs3.java2110.ass1gc;

import java.util.*;
import java.io.*;

public class DNADemo {

 public static void main(String[] args) throws IOException{
	 long st, et, ex;
	 
  Scanner kb = new Scanner(System.in);
  System.out.print("Please file String:");
  String a=kb.nextLine();
  System.out.print("Please enter SubString:");
  String b=kb.nextLine();
  File fl = new File(a);
  Scanner ip = new Scanner(fl);
  int count=0;
  st = System.currentTimeMillis();
		  
  while(ip.hasNext())
  {
   String c = ip.nextLine();
   DNAMatch m = new DNAMatch(c,b);
   count+=m.check(c,b);//sum of everyline's count 
  }
  
  if(count==0)
  {
   System.out.println("No matches - substring "+b+" was not found in "+a);
  }else {
   System.out.println("Substring "+ b + " was found in "+a+" " + count+" times");
  }
  et = System.currentTimeMillis();
  ex = et-st;
  System.out.println(ex+" ms");
  
 }

}