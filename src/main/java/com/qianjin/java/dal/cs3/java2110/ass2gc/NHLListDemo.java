/*
 * Assignment 2 Question 1 CSCI 2110
 * 
 * NHLListDemo.java show how to use NHLList class to display
 * 
 * Oct 23rd, 2017 Yiping
 * 
 * Liang B00744822 This is entirely my own work.
 */
package com.qianjin.java.dal.cs3.java2110.ass2gc;

import java.io.*;
import java.util.*;

public class NHLListDemo {

    public static void main(String[] args) throws IOException {
        // start to load data from file
        Scanner kb = new Scanner(new File("nhlstats.txt"));
        List<PlayerRecord> list = new List<PlayerRecord>();
        while (kb.hasNextLine()) {
            String line=kb.nextLine();
            if(line==null || line.trim().length()<5) continue;
            Scanner sc = new Scanner(line);
            PlayerRecord p = new PlayerRecord();
            p.setName(sc.next());
            p.setPosition(sc.next());
            p.setTeamname(sc.next());
            p.setGame(sc.nextInt());
            p.setGoalscore(sc.nextInt());
            p.setAssists(sc.nextInt());
            p.setPenalties(sc.nextInt());
            p.setShots(sc.nextInt());
            p.setWinninggoals(sc.nextInt());
            list.add(p);
        }
        // start to calculate the report
        NHLList n = new NHLList(list);
        PrintWriter p = new PrintWriter("nhlstatsoutput.txt");
        p.println("NHL Results Summary");
        p.println("");

        List<PlayerRecord> l = n.display1();
        p.println("Players with highest points and their teams:");
        PlayerRecord curr = l.first();
        while (curr != null) {
            p.println(curr.getName() + "," + curr.getTeamname());
            curr = l.next();
        }

        p.println("");
        l = n.display2();
        p.println("Most aggressive players, their teams and their positions:");
        curr = l.first();
        while (curr != null) {
            p.println(curr.getName() + "," + curr.getTeamname() + "," + curr.getPosition());
            curr = l.next();
        }

        p.println("");
        l = n.display3();
        p.println("Most valuable players and their teams:");
        curr = l.first();
        while (curr != null) {
            p.println(curr.getName() + "," + curr.getTeamname());
            curr = l.next();
        }

        p.println("");
        l = n.display4();
        p.println("Most promising players and their teams:");
        curr = l.first();
        while (curr != null) {
            p.println(curr.getName() + "," + curr.getTeamname());
            curr = l.next();
        }

        p.println("");
        List<PlayerTeam> t = n.display5();
        p.println("Teams that had the most number of penalty minutes:");
        PlayerTeam c = t.first();
        while (c != null) {
            p.println(c.getName());
            c = t.next();
        }

        p.println("");
        t = n.display6();
        p.println("Teams that had the most number of game winning goals:");
        c = t.first();
        while (c != null) {
            p.println(c.getName());
            c = t.next();
        }
        p.close();
    }

}
