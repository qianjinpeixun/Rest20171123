/*Assignment 1 Question 2 CSCI 2110
  genericQueue.java checks wether contains the subString 
    Oct 3st, 2017
   Yiping Liang B00744822
   This is entirely my own work. */
package assignment1;
import java.util.*;

public class StringMatch {
		private String a;//string
		private String b;//sub
		public StringMatch(String a, String b) {
			
			this.a = a;
			this.b = b;
		}
		public String getA() {
			return a;
		}
		public String getB() {
			return b;
		}
		public void setA(String a) {
			this.a = a;
		}
		public void setB(String b) {
			this.b = b;
		}

		public void check(String a, String b) {
			int count=0;
			int i=0;
			while(i<a.length())//from the first charactor in String to last
			{
				int len=1;
				if(a.charAt(i)==b.charAt(0)&&a.length()>=i+b.length())//first mathches first
				{
					
					for(int j=1;j<b.length();j++)//from subString second charactor
					{
						
						if(a.charAt(i+j)!=b.charAt(j))//from the second character in subString does not match follwer charactor in string
						{
							len = j;
							break;
						}else
						{
							len++;// how many character does substring contains
						}
						
					}
					if(len==b.length())//size equals subString's length
					{
						count++;
					}
					
				}
				i+=len;//after the first appear substring's position 
			}
			
			if(count==0)
			{
				System.out.println("No matches - substring " + b + " was not found in " + a);
			}else {
				 System.out.println("Substring" + b + " was found in" + a + " " + count + " times");

			}
		}
	}


