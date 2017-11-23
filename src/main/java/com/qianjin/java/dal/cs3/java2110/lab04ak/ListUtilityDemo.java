package com.qianjin.java.dal.cs3.java2110.lab04ak;

import java.util.Scanner;

/**
 * This class is designed as a test class for CSCI 2110- Data Structures and
 * Algorithms Laboratory No. 4 Exercise 2
 * 
 * This class will test all the methods of ListUtility
 * 
 */
public class ListUtilityDemo {
    // list will be from input data supplied by the user
    private static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {

        List<String> list1 = new List<String>();
        List<String> list2 = new List<String>();
        List<String> list3 = new List<String>();

        // test the first findUnion method
        System.out.println("\nIn order to test findUnion, you need to enter two list.");
        list1 = getInput("Please enter the first list");
        list2 = getInput("Please enter the second list");
        list3 = ListUtility.findUnion(list1, list2);
        System.out.println("the union list of list1 and list2 is as below:");
        list3.enumerate();
        System.out.println();

        // test the second method: findIntersection
        System.out.println("\nIn order to test findIntersection, you need to enter two list.");
        list1 = getInput("Please enter the first list");
        list2 = getInput("Please enter the second list");
        list3 = ListUtility.findIntersection(list1, list2);
        System.out.println("the intersection list of list1 and list2 is as below:");
        list3.enumerate();
        System.out.println();

        // test the third method: interleave
        System.out.println("\nIn order to test interleave, you need to enter two list.");
        list1 = getInput("Please enter the first list");
        list2 = getInput("Please enter the second list");
        list3 = ListUtility.interleave(list1, list2);
        System.out.println("the interleave list of list1 and list2 is as below:");
        list3.enumerate();
        System.out.println();

        // test the fourth method: chopSkip
        System.out.println("\nIn order to test chopSkip, you need to enter one list.");
        list1 = getInput("Please enter the list");
        list3 = ListUtility.chopSkip(list1);
        System.out.println("\nTest chopSkip, the chopSkip list is as below:");
        list3.enumerate();
        System.out.println();
    }

    /**
     * This is a helper method in order to get the data entered by user
     * 
     * @param sss
     *            the welcome message
     * @return List contains the string object by default
     */
    private static List<String> getInput(String sss) {
        System.out.println(sss);
        List<String> list = new List<String>();
        String str = kb.nextLine();
        Scanner sc = new Scanner(str);
        // split the input string into multi objects
        while (sc.hasNext()) {
            String w = sc.next();
            list.add(w);
        }
        return list;
    }

}
