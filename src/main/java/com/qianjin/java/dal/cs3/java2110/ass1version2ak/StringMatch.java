package com.qianjin.java.dal.cs3.java2110.ass1version2ak;

import java.util.Scanner;

/*
 * This class is designed to test whether the second string is a substring of
 * the first string. The number of times the substring appears will be
 * displayed.
 * 
 * The method to calculate the numbers do not use the indexOf method in the
 * String class , a version of the indexOf method has been implemented. If the
 * second string is not a substring of the first string, then display something
 * like “No matches – substring (aaa) was not found in (bbb)”.
 * 
 */
public class StringMatch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string:");
        String s1 = scanner.nextLine();
        System.out.print("Enter a substring:");
        String s2 = scanner.nextLine();

        // start to calculate the numbers
        int count = getCount(s1, s2);
        if (count > 0)
            System.out.println("Substring " + s2 + " was found in " + s1 + " " + count + " times");
        else
            System.out.println("No matches - substring " + s2 + " was not found in " + s1);
    }

    /**
     * This method return the numbers of substring in main string
     * 
     * @param s1
     *            candidate string
     * @param s2
     *            substring
     * @return numbers
     */
    public static int getCount(String s1, String s2) {
        int count = 0;
        int index = 0;
        while (true) {
            // to find if substring is in main string
            index = indexof(s1, s2);
            if (index == -1) {
                break;
            }
            // if found substring in main string, cut the main string and then
            // find again
            s1 = s1.substring(index + s2.length());
            count++;
        }
        return count;
    }// end getCount

    /**
     * This method is desgined as an alternative version of IndexOf
     * 
     * @param s1
     *            main string
     * @param s2
     *            substring
     * @return true if substring is in main string, otherwise return false
     */
    private static int indexof(String s1, String s2) {
        // if s1 equals s2, return 0 as index number
        if (s1.equals(s2))
            return 0;
        // if s1 or s2 is empty, return -1, means mismatch
        if (s1.length() == 0 || s2.length() == 0)
            return -1;
        // by default, return mismatch
        int index = -1;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            // if the first char in substring is found in main string
            if (c1 == s2.charAt(0)) {
                int position1 = i + 1;
                int position2 = 1;
                boolean isSub = false;
                // start to compare the rest characters
                while (true) {
                    // if reach the end of s1
                    if (position1 >= s1.length()) {
                        isSub = false;
                        break;
                    }
                    // if reach the end of s2
                    if (position2 >= s2.length()) {
                        isSub = true;
                        break;
                    }
                    // if found a different character,means mismatch
                    if (s1.charAt(position1) != s2.charAt(position2)) {
                        isSub = false;
                        break;
                    } else {
                        // if the current character is the same, continue to
                        // look the next character
                        position1++;
                        position2++;
                    }
                } // end while loop
                  // if the whole substring exists in the main string, found it,
                  // return the index
                if (isSub == true) {
                    return i;
                }
            }
        } // end for loop
        return index;
    }// end indexof
}
