package com.qianjin.java.dal.cs3.java2110.a2132a5;

import java.util.Arrays;

public class Test {

    private static void f_c(int n, int a[]) {
        f_c1(0, n - 1, a);
    }

    private static void f_c1(int i, int j, int a[]) {
        for (int ii = 0; ii < 5; ii++) {
            System.out.print(a[ii] + " ");
        }
        System.out.println("i=" + i + ",j=" + j + "");
        int tmp;
        if (i >= j)
            return;
        tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        f_c1(i + 1, j - 1, a);
    }

    public static void main(String[] args) {

        int[][] a = new int[4][4];
        int[][] b = new int[4][4];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                a[i][j] = i * 4 + j + 11;
            }
        print(a);

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                b[j][4 - 1 - i] = a[i][j];
            }

        System.out.println();
        System.out.println();
        System.out.println();

        print(b);

        System.out.println();
        System.out.println();
        System.out.println();

        int[] aa = { 1, 2, 3, 4, 5 };
        System.out.println(f_b(5, aa));

        f_c(5, aa);
        for (int i = 0; i < 5; i++) {
            System.out.print(aa[i] + " ");
        }

    }

    private static int f_b(int n, int a[]) {

        int m;
        if (n == 1)
            return a[0];
        m = f_b(n - 1, a);
        if (m > a[n - 1])
            return a[n - 1];
        else
            return m;
    }

    public static void print(int[][] a) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
