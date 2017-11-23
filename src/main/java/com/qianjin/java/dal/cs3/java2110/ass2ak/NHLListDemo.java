package com.qianjin.java.dal.cs3.java2110.ass2ak;

import java.io.*;
import java.util.*;

/**
 * This class is designed as a client program with the main method that reads
 * the file nhlstats.txt and prints the following into another file
 * nhlstatsoutput.txt.
 *
 */
public class NHLListDemo {

    public static void main(String[] args) throws FileNotFoundException {

        // A file including raw scores of various NHL players’ regular hockey
        // games:nhlstats.txt is given, download from web site.
        File file = new File("nhlstats.txt");
        Scanner scanner = new Scanner(file);
        NHLStats nhl = new NHLStats();
        while (scanner.hasNext()) {
            // read data from the file, each line is read as a String.
            String line = scanner.nextLine();
            // Use StringTokenizer to break it down into individual components
            // the input file has rows in which the items are delimited by tabs.
            StringTokenizer token = new StringTokenizer(line, "\t");
            while (token.hasMoreTokens()) {

                String name = token.nextToken();
                String pos = token.nextToken();
                String team = token.nextToken();
                int gp = Integer.parseInt(token.nextToken());
                int g = Integer.parseInt(token.nextToken());
                int a = Integer.parseInt(token.nextToken());
                int pim = Integer.parseInt(token.nextToken());
                int sog = Integer.parseInt(token.nextToken());
                int gwg = Integer.parseInt(token.nextToken());
                int score = g + a;
                PlayerRecord record = new PlayerRecord(name, pos, team, gp, g, a, pim, sog, gwg, score);
                nhl.add(record);
            }
        }
        scanner.close();

        // start to print summary
        String filename = "nhlstatsoutput.txt";
        PrintWriter printWriter = new PrintWriter(new File(filename));
        String output = "NHL Results Summary\r\n";
        printWriter.println(output);
        System.out.println(output);

        output = "Players with highest points and their teams:";
        System.out.println(output);
        printWriter.println(output);
        output = nhl.getPlayersWithHighestPoint();
        System.out.println(output);
        printWriter.println(output);

        output = "\r\nMost aggressive players, their teams and their positions:";
        System.out.println(output);
        printWriter.println(output);
        output = nhl.getMostAggressivePlayers();
        System.out.println(output);
        printWriter.println(output);

        output = "\r\nMost valuable players and their teams:";
        System.out.println(output);
        printWriter.println(output);
        output = nhl.getMostValuablePlayers();
        System.out.println(output);
        printWriter.println(output);

        output = "\r\nMost promising players and their teams:";
        System.out.println(output);
        printWriter.println(output);
        output = nhl.getPromisingPlayers();
        System.out.println(output);
        printWriter.println(output);

        output = "\r\nTeams that had the most number of penalty minutes:";
        System.out.println(output);
        printWriter.println(output);
        output = nhl.getTeamWithMostPenaltyMinutes();
        System.out.println(output);
        printWriter.println(output);

        output = "\r\nTeams that had the most number of game winning goals:";
        System.out.println(output);
        printWriter.println(output);
        output = nhl.getTeamWithMostGameWinningGoals();
        System.out.println(output);
        printWriter.println(output);

        printWriter.close();
    }

}
