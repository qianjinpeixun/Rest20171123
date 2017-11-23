package com.qianjin.java.dal.cs3.java2110.ass1cui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test2 extends test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        System.out.print("Please enter a number: ");
        int num = input.nextInt();
        list = getAllBinaryNumbers(list, num);
        System.out.println(list);
        list = pickUpBinaryNumbers(list, num);
        System.out.println(list);
        list = printRoute(list);
        System.out.println("printRoute=" + list);
        getDiagnalRoute("EENN",1);
        System.out.println(getAllRoute(list).size());


    }

    public static List<String> getAllRoute(List<String> list) {
        int size=list.size();
        for (int i = 0; i < size/ 2; i++) {
            int n = 0;
            String str = list.get(i);
            for (int j = n; j < str.length(); j++) {
                if (j + 1 > str.length() - 1)
                    break;
                else if (str.charAt(j) != str.charAt(j + 1)) {
                    list.add(getDiagnalRoute(str, j));
                }
            }
            n++;
            System.out.println("getAllRoute first loop str="+str+",i="+i+",list size="+list.size()+",list="+list);
        }
        return list;
    }

    public static String getDiagnalRoute(String str, int num) {
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            if (num == i) {
                s += "D";
                i++;
            } else {
                s += String.valueOf(str.indexOf(i));
            }
        }
        System.out.println("getDiagnalRoute str=" + str + ",num" + num + ",s=" + s);
        return s;
    }
}