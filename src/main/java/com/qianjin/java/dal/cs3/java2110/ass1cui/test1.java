package com.qianjin.java.dal.cs3.java2110.ass1cui;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        System.out.print("Please enter a number: ");
        int num = input.nextInt();
        list = getAllBinaryNumbers(list, num);
        System.out.println(list);
        list = pickUpBinaryNumbers(list, num);
        System.out.println(list);
        System.out.print(printRoute(list).size());
    }

    public static List<String> getAllBinaryNumbers(List<String> list, int num) {
        int i = 1;
        for (int j = num * 2; j > 0; j--) {
            i = i * 2;
        }
        for (i = i - 1; i >= 0; i--) {
            String bin = Integer.toBinaryString(i);
            while (bin.length() < num * 2) {
                bin = "0" + bin;
            }
            list.add(bin);
        }
        return list;
    }

    public static List<String> pickUpBinaryNumbers(List<String> list, int num) {
        for (int j = 0; j < list.size(); j++) {
            int num1 = 0, num2 = 0;
            char[] ch = list.get(j).toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == '0')
                    num1++;
                else if (ch[i] == '1')
                    num2++;
            }
            if (num1 != num || num2 != num) {
                list.remove(j);
                j--;
            }
        }
        return list;
    }

    public static List<String> printRoute(List<String> list) {
        for (int j = 0; j < list.size(); j++) {
            String str = "";
            for (int i = 0; i < list.get(j).length(); i++) {
                if (list.get(j).charAt(i) == '0')
                    str += "E";
                else
                    str += "N";
            }
            list.set(j, str);
        }
        return list;
    }
}
