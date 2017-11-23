package com.qianjin.java.sss.java2s.a1101.lab07;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {

        ArrayList<String> list1=new ArrayList<String>();
        list1.add("friend");
        list1.add("delete");
        list1.add("bike");
        list1.add("apple");
        list1.add("call");
        list1.add("element");
        AlphabetizedList al1=new AlphabetizedList(list1);

        System.out.println("After create the first AlphabetizedList.");
        System.out.println("The first AlphabetizedList is:");
        System.out.println(al1.toString());
        System.out.println("");
        
        ArrayList<String> list2=new ArrayList<String>();
        list2.add("effective");
        list2.add("flow");
        list2.add("bell");
        list2.add("zoo");
        list2.add("canada");
        list2.add("add");
        list2.add("year");
        list2.add("high");
        list2.add("dance");
        list2.add("student");
        list2.add("go");
        
        AlphabetizedList al2=new AlphabetizedList(list2);
        System.out.println("After create the second AlphabetizedList");
        System.out.println("The second AlphabetizedList is:");
        System.out.println(al2.toString());
        System.out.println("");

        al1.merge(al2);
        System.out.println("After merge the second AlphabetizedList to the first AlphabetizedList");
        System.out.println("The first AlphabetizedList is:");
        System.out.println(al1.toString());
        
        
    }
}
