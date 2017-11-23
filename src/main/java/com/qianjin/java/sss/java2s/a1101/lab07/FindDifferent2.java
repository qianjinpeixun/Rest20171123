package com.qianjin.java.sss.java2s.a1101.lab07;

import java.util.Scanner;
import java.util.ArrayList;

public class FindDifferent2 {
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
		for (int x = 0; x < a1.size(); x++) {// remove the common data of set
												// one.
			for (int k = x + 1; k < a1.size(); k++) {
				if (a1.get(x).equals(a1.get(k))) {
					a1.remove(k);
					x--;
					break;
				}
			}
		}

		System.out.println("Enter words in one line,end with -1");
		String n2 = kb.next();
		while (!n2.equals("-1")) {// store the set two.
			a2.add(n2);
			n2 = kb.next();
		}
		for (int y = 0; y < a2.size(); y++) {// remove the common data of the
												// set two.
			for (int l = y + 1; l < a2.size(); l++) {
				if (a2.get(y).equals(a2.get(l))) {
					a2.remove(y);
					y--;
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

		for (int l = 0; l < a3.size(); l++) {
			for (int k = l + 1; k < a3.size(); k++) {
				if ((a3.get(l)).equals(a3.get(k))) {
					a3.remove(a3.remove(l));
					l--;
					break;
				}
			}
		}

		System.out.println("Array List with distinct strings:\n" + a3);

	}

}
