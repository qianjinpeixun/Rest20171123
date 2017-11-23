package com.qianjin.java.sss.java2s.a1101.lab07;

import java.util.Scanner;
import java.util.ArrayList;

public class FindDifferent {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        ArrayList<String> a1 = new ArrayList<String>();
        ArrayList<String> a2 = new ArrayList<String>();
        ArrayList<String> a3 = new ArrayList<String>();

        System.out.println("Enter words in one line,end with -1");
        String n1 = kb.next();
        while (!n1.equals("-1")) {// store the set one.
            a1.add(n1);
            n1 = kb.next();
        }

        System.out.println("Enter words in one line,end with -1");
        String n2 = kb.next();
        while (!n2.equals("-1")) {// store the set two.
            a2.add(n2);
            n2 = kb.next();
        }

        for (int i = 0; i < a1.size(); i++) {
            boolean found = false;
            for (int j = 0; j < a2.size(); j++) {
                if (a1.get(i).equals(a2.get(j))) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                boolean b = false;
                for (int j = 0; j < a3.size(); j++) {
                    if (a1.get(i).equals(a3.get(j))) {
                        b = true;
                        break;
                    }
                }
                if (b == false)
                    a3.add(a1.get(i));
            }
        }

        for (int i = 0; i < a2.size(); i++) {
            boolean found = false;
            for (int j = 0; j < a1.size(); j++) {
                if (a2.get(i).equals(a1.get(j))) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                boolean b = false;
                for (int j = 0; j < a3.size(); j++) {
                    if (a2.get(i).equals(a3.get(j))) {
                        b = true;
                        break;
                    }
                }
                if (b == false)
                    a3.add(a2.get(i));
            }
        }

        System.out.println("Array List with distinct strings:\n" + a3);

    }

}
