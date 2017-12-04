package com.qianjin.java.dal.cs3.java2110.project1;

import java.math.BigInteger;

public class VerifyAlgorithm {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            
            
            Thread t1 = new Thread(() -> {
               Maths.bigFactorial(5);
            });
            t1.start();
        }
    }

}
