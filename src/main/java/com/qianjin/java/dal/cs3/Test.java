package com.qianjin.java.dal.cs3;

import java.io.*;
import java.util.Random;

public class Test {

    public static String RandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(52);
            buf.append(str.charAt(num));
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        try {
            PrintWriter p = new PrintWriter(new File("c:/FPC/csource/test2.in"));
            String s = "";
            for (int i = 0; i < 20000; i++) {

                s = s + " " + RandomString(15);
                if (i == 5000) {
                    s = s + "asdfjkasdfhasdkjfhsdakjfhksdjafnjksdahfksdjafhkjsdah43uiwerqyesiakjfhasdjkf";
                }
                if (i % 100 == 0) {
                    p.println(s);
                    s = "";
                }
            }
            p.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
