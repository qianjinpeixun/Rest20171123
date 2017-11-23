package com.qianjin.java.sss.java2s.a1101.lab07;

import java.util.Scanner;
import java.util.ArrayList;

public class FindCommon2 {

	public static void main(String[] args) {

		ArrayList<String> a1 = new ArrayList<String>();
		ArrayList<String> a2 = new ArrayList<String>();
		ArrayList<String> a3 = new ArrayList<String>();
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the first set of integers on one line, end with -1");
		String n = kb.next();

		while (!n.equals("-1")) {// get the first set
			a1.add(n);
			n = kb.next();
		}
		for (int i = 0; i < a1.size(); i++) {// make it no common
			for (int j = i + 1; j < a1.size(); j++) {
				if (a1.get(i).equals(a1.get(j))) {
					a1.remove(i);
					i--;
					break;
				}
			}
		}
		System.out.println("Enter the second set of integers on one line, end with -1");
		String e = kb.next();

		while (!e.equals("-1")) {// get the second set
			a2.add(e);
			e = kb.next();
		}
		for (int i = 0; i < a2.size(); i++) {// make it no common
			for (int j = i + 1; j < a2.size(); j++) {
				if (a2.get(i).equals(a2.get(j))) {
					a2.remove(i);
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < a1.size(); i++) {
			a3.add(a1.get(i));
		}
		for (int i = 0; i < a2.size(); i++) {
			a3.add(a2.get(i));
		}
		ArrayList<String> shared = new ArrayList<String>();
		for (int i = 0; i < a3.size(); i++) {
			for (int j = i + 1; j < a3.size(); j++) {
				if ((a3.get(i)).equals(a3.get(j))) {
					shared.add(a3.get(j));// get the common data of two sets
					a3.remove(a3.remove(j));

					i--;
					break;
				}
			}
		}
		System.out.println("Array List with shared Integers:\n" + shared);

	}
}
