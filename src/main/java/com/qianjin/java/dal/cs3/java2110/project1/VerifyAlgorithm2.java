package com.qianjin.java.dal.cs3.java2110.project1;

import java.math.BigInteger;

public class VerifyAlgorithm2 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread("number"+i) {
                public void run() {
                    System.out.print("\n"+Thread.currentThread().getName()+","+Maths.newbigFactorial(5));
                }
            };
            thread.start();
        }
    }

}
