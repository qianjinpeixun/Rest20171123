package com.qianjin.java.dal.cs3.java2110.ass1ak;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DNAMatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename to read from: ");
        System.out.print("Enter the test string: ");
        String fileName = "";
        String str = "CC";
        int count = 0;

        try {
            
            Scanner fileReader = new Scanner(new File("Genome.txt"));
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                int cunt = StringMatch.getCount(line, str);
                if (cunt != -1) {
                    count = count + cunt;
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("count="+count);
    }

}
