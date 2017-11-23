/*Assignment 1 Question 2 CSCI 2110
 * 10.3 DNAmatch.java
 * Yiping Liang B00744822
 *  This is entirely my own work. */
 
package assignment1;

import java.util.*;

public class DNAMatch {
 private String a;//file
 private String b;//substring

 public DNAMatch() {}
 

 public DNAMatch(String a, String b) {
	
	this.a = a;
	this.b = b;
}
public void setA(String a) {
	this.a = a;
}
public void setB(String b) {
	this.b = b;
}
public String getA() {
	return a;
}
public String getB() {
	return b;
}
public int check(String a, String b) {
  int count=0;
  int i=0;
  while(i<a.length())//from the first charactor in String to last
  {
   int len=1;
   if(a.charAt(i)==b.charAt(0)&&a.length()>=i+b.length())//first mathches first
   {
    
    for(int j=1;j<b.length();j++)//from subString second charactor
    {
     //charactor does not match
     if(a.charAt(i+j)!=b.charAt(j))//from the second character in subString does not match follwer charactor in string
     {
      len = j;
      break;
     }else
     {
      len++;// how many character does substring contains
     }
     
    }
    if(len==b.length())
    {
     count++;
    }
    
   }
   i++;
  }
  return count;
  
 }
}