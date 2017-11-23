package com.qianjin.java.math.dp;

public class MiniCoin1 {

    public static void main(String[] args) {
        int[] coins = { 25, 10, 5, 1 };
        int value = 99;
        int[] ret=greeting(value, coins);
        for(int i:ret){
            System.out.println(i);
        }
       
    }

    private static int[] greeting(int value, int[] coins) {
        int count=0;
        int v = value;
        int[] values = new int[coins.length];
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > v)
                continue;
            values[i] = v / coins[i];
            v = v % coins[i];
            count++;
        }
        System.out.println("gree count="+count);
        return values;
    }

   

    private static int cal(int value, int[] coins) {

        if (value == 0)
            return 0;

        return cal(value - 1, coins);

    }

}
