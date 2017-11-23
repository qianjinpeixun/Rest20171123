package com.qianjin.java.dal.cs3.java2110.ass1v02;

import java.util.*;

public class Test01 {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(7);
        list3.add(8);
        List<List<Integer>> allList = new ArrayList<>();
        allList.add(list1);
        allList.add(list2);
        allList.add(list3);
        calculateCombination(allList);
    }

    public static void calculateCombination(List<List<Integer>> inputList) {
        List<Integer> combination = new ArrayList<Integer>();
        int n = inputList.size();
        for (int i = 0; i < n; i++) {
            combination.add(0);
        }
        int i = 0;
        boolean isContinue = false;
        do {
            // 打印一次循环生成的组合
            for (int j = 0; j < n; j++) {
                System.out.print(inputList.get(j).get(combination.get(j)) + ", ");
            }
            System.out.println();

            i++;
            combination.set(n - 1, i);
            for (int j = n - 1; j >= 0; j--) {
                if (combination.get(j) >= inputList.get(j).size()) {
                    combination.set(j, 0);
                    i = 0;
                    if (j - 1 >= 0) {
                        combination.set(j - 1, combination.get(j - 1) + 1);
                    }
                }
            }
            isContinue = false;
            for (Integer integer : combination) {
                if (integer != 0) {
                    isContinue = true;
                }
            }
        } while (isContinue);
    }

}
