package com.qianjin.java.sss.java2s.a1101.lab07;

import java.util.Scanner;
import java.util.ArrayList;

public class FindCommon {

	public static void main(String[] args) {

		ArrayList<Integer> int1  = new ArrayList<Integer>();
		ArrayList<Integer> int2  = new ArrayList<Integer>();
		ArrayList<Integer> int3  = new ArrayList<Integer>();
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the first set of integers on one line, end with -1");
		int input=0;
		while ((input=kb.nextInt())!=-1) {// get the first set
		    int1.add(input);
		}
		System.out.println("Enter the second set of integers on one line, end with -1");
		
		while ((input=kb.nextInt())!=-1) {// get the first set
            int2.add(input);
        }
		
		for(int i=0;i<int1.size();i++){
		    boolean found=false;
		    for(int j=0;j<int2.size();j++){
		        if(int1.get(i).equals(int2.get(j))){
		            found=true;
		            break;
		        }
		    }
		    if(found){
		        int3.add(int1.get(i));
		    }
		}
		System.out.println("Array List with shared Integers:\n" + int3);

	}
}
