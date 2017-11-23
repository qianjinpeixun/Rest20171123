/*
 * Assignment 2 Question 1 CSCI 2110
 * 
 * NHLList.java make the analysis calculation 
 * 
 * Oct 23rd, 2017 Yiping
 * 
 * Liang B00744822 This is entirely my own work.
 */

package com.qianjin.java.dal.cs3.java2110.ass2gc;

public class NHLList {

    private List<PlayerRecord> playerlist;

    public NHLList(List<PlayerRecord> playerlist) {
        this.playerlist = playerlist;
    }

    // maximum number of points
    public List<PlayerRecord> display1() {
        List<PlayerRecord> l = new List<PlayerRecord>();
        int max = 0;
        PlayerRecord curr = playerlist.first();

        while (curr != null) {
            int c = curr.getGoalscore() + curr.getAssists();
            if (c > max) {// if is a new maximum value, empty the list
                l.clear();
                l.add(curr);
                max = c;
            } else if (c == max) { // if there are more than one maximum value,
                                   // add it
                l.add(curr);
            }
            curr = playerlist.next();
        }
        return l;
    }

    // maximum number of penalty minutes
    public List<PlayerRecord> display2() {
        List<PlayerRecord> l = new List<PlayerRecord>();
        int max = 0;
        PlayerRecord curr = playerlist.first();
        while (curr != null) {
            int c = curr.getPenalties();
            if (c > max) {// if is a new maximum value, empty the list
                l.clear();
                l.add(curr);
                max = c;
            } else if (c == max) { // if there are more than one maximum value,
                                   // add it
                l.add(curr);
            }
            curr = playerlist.next();
        }
        return l;
    }

    // maximun number of game winning goals
    public List<PlayerRecord> display3() {
        List<PlayerRecord> l = new List<PlayerRecord>();
        int max = 0;
        PlayerRecord curr = playerlist.first();
        while (curr != null) {
            int c = curr.getWinninggoals();
            if (c > max) {// if is a new maximum value, empty the list
                l.clear();
                l.add(curr);
                max = c;
            } else if (c == max) { // if there are more than one maximum value,
                                   // add it
                l.add(curr);
            }
            curr = playerlist.next();
        }
        return l;
    }

    // most number of shots on goal
    public List<PlayerRecord> display4() {
        List<PlayerRecord> l = new List<PlayerRecord>();
        int max = 0;
        PlayerRecord curr = playerlist.first();
        while (curr != null) {
            int c = curr.getShots();
            if (c > max) {// if is a new maximum value, empty the list
                l.clear();
                l.add(curr);
                max = c;
            } else if (c == max) { // if there are more than one maximum value,
                                   // add it
                l.add(curr);
            }
            curr = playerlist.next();
        }
        return l;
    }

    // most penalty minutes
    public List<PlayerTeam> display5() {
        List<PlayerTeam> l = new List<PlayerTeam>();
        List<PlayerTeam> all = build();
        int max = 0;
        PlayerTeam curr = all.first();
        while (curr != null) {
            int c = curr.getPenalties();
            if (c > max) {// if is a new maximum value, empty the list
                l.clear();
                l.add(curr);
                max = c;
            } else if (c == max) { // if there are more than one maximum value,
                                   // add it
                l.add(curr);
            }
            curr = all.next();
        }
        return l;
    }
    
    // most game winning goals
    public List<PlayerTeam> display6() {
        List<PlayerTeam> l = new List<PlayerTeam>();
        List<PlayerTeam> all = build();
        int max = 0;
        PlayerTeam curr = all.first();
        while (curr != null) {
            int c = curr.getWinninggoals();
            if (c > max) {// if is a new maximum value, empty the list
                l.clear();
                l.add(curr);
                max = c;
            } else if (c == max) { // if there are more than one maximum value,
                                   // add it
                l.add(curr);
            }
            curr = all.next();
        }
        return l;
    }

    // build team list
    private List<PlayerTeam> build() {
        List<PlayerTeam> l = new List<PlayerTeam>();
        PlayerRecord curr = playerlist.first();
        while (curr != null) {
            String name = curr.getTeamname();
            if (!exist(l, name)) {
                PlayerTeam t = new PlayerTeam();
                t.setName(name);
                l.add(t);
            }
            curr = playerlist.next();
        }

        PlayerTeam c = l.first();
        while (c != null) {
            String name = c.getName();
            c.setPenalties(get1(name));
            c = l.next();
        }

        c = l.first();
        while (c != null) {
            String name = c.getName();
            c.setWinninggoals(get2(name));
            c = l.next();
        }
        return l;
    }

    // get total winning goals according to team name
    private int get2(String name) {
        int t = 0;
        PlayerRecord curr = playerlist.first();
        while (curr != null) {
            if (curr.getTeamname().equals(name))
                t = t + curr.getWinninggoals(); // sum of all GWGs
            curr = playerlist.next();
        }
        return t;
    }

    // get total penalty according to team name
    private int get1(String name) {
        int t = 0;
        PlayerRecord curr = playerlist.first();
        while (curr != null) {
            if (curr.getTeamname().equals(name))
                t = t + curr.getPenalties(); // sum of all penalty minutes
            curr = playerlist.next();
        }
        return t;
    }

    // if team name is in one list
    private boolean exist(List<PlayerTeam> l, String name) {
        boolean ex = false;
        PlayerTeam curr = l.first();
        while (curr != null) {
            if (curr.getName().equals(name))
                return true;
            curr = l.next();
        }
        return ex;
    }

}
