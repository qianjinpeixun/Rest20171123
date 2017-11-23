package com.qianjin.java.dal.cs3.java2110.ass1ak;

import java.util.ArrayList;

public class Question1b {


    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        int n = 2;
        long startTime, endTime, executionTime;
        startTime = System.currentTimeMillis();
        //include the code snippet (or call to the method) here
        
        getCount(n, 0, 0, "", list);
        printPath(list, n);
        
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

    }

    public static void printPath(ArrayList<String> list, int n) {
        String output="[";
        for (String line : list) {
            
            int size=line.length()/2;
            
            
            int[][] arr = new int[size][2];
            for (int i = 0; i < size; i++) {
                String ss = line.substring(i * 2, i * 2 + 2);
                arr[i][0] = Integer.valueOf(String.valueOf(ss.charAt(0))).intValue();
                arr[i][1] = Integer.valueOf(String.valueOf(ss.charAt(1))).intValue();
            }
            String path = "";
            for (int i = 1; i <size; i++) {

                if (arr[i][0] > arr[i - 1][0] && arr[i][1] > arr[i - 1][1])
                    path = path + "D";
                else if (arr[i][0] > arr[i - 1][0]){
                    path = path + "N";
                }else
                    path = path + "E";
            }
            output=output+path+",";
        }
        output=output.substring(0,output.length()-1)+"]";
        System.out.println(output);
    }

    public static void getCount(int n, int row, int col, String path, ArrayList<String> list) {
        path = path + row + "" + col;
        if (row == n && col == n) {
            list.add(path);
        } else if (row > n || col > n) {
            return;
        } else {
            getCount(n, row + 1, col, path, list);
            getCount(n, row, col + 1, path, list);
            getCount(n, row+1, col + 1, path, list);
        }
    }
}
