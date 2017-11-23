package com.qianjin.java.dal.cs3.java2110.ass2hh;

import java.util.ArrayList;

public class NHLStats {
    private List<PlayerRecord> playerlist;

    public NHLStats(List<PlayerRecord> playerlist) {
        this.playerlist = playerlist;
    }

    private int getMax(int type) {
        PlayerRecord curr = playerlist.first();
        int max = 0;
        while (curr != null) {
            int c = 0;
            if (type == 0) // higest point
                c = curr.getG() + curr.getA();
            else if (type == 1) // most aggressive
                c = curr.getPim();
            else if (type == 2) // mvp
                c = curr.getGwg();
            else if (type == 3) // promising
                c = curr.getSog();
            if (c > max) {
                max = c;
            }
            curr = playerlist.next();
        }
        return max;
    }

    private void print(int type) {
        int max = getMax(type);
        PlayerRecord curr = playerlist.first();
        while (curr != null) {

            int c = 0;
            if (type == 0) // higest point
                c = curr.getG() + curr.getA();
            else if (type == 1) // most aggressive
                c = curr.getPim();
            else if (type == 2) // mvp
                c = curr.getGwg();
            else if (type == 3) // promising
                c = curr.getSog();

            if (c == max) {
                if (type == 0 || type == 2 || type == 3) {
                    System.out.println("player name is:" + curr.getName() + " and team is:" + curr.getTeam());
                } else {
                    System.out.println("player name is:" + curr.getName() + " , team is:" + curr.getTeam() + " and position is:" + curr.getPos());

                }
            }
            curr = playerlist.next();
        }
    }

    private ArrayList<String> getteam() {
        ArrayList<String> list = new ArrayList<String>();
        PlayerRecord curr = playerlist.first();
        while (curr != null) {
            if (!list.contains(curr.getTeam()))
                list.add(curr.getTeam());//no duplicate data
            curr = playerlist.next();
        }
        return list;
    }

    private int getpim(String name) {
        int total = 0;
        PlayerRecord curr = playerlist.first();
        while (curr != null) {
            if (curr.getTeam().equals(name)) {
                total = total + curr.getPim();
            }
            curr = playerlist.next();
        }
        return total;
    }

    private int getgwg(String name) {
        int total = 0;
        PlayerRecord curr = playerlist.first();
        while (curr != null) {
            if (curr.getTeam().equals(name)) {
                total = total + curr.getGwg();
            }
            curr = playerlist.next();
        }
        return total;
    }

    public void team2() {
        ArrayList<String> list = getteam();
        ArrayList<Team> ll = new ArrayList<Team>();
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            int total = getgwg(name);
            Team team = new Team(name, total);
            ll.add(team);
        }

        ArrayList<Team> fin = getmaxteam(ll);
        for (int i = 0; i < fin.size(); i++) {
            System.out.println("team name is:" + fin.get(i).getName());

        }
    }

    public void team1() {
        ArrayList<String> list = getteam();
        ArrayList<Team> ll = new ArrayList<Team>();
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            int total = getpim(name);
            Team team = new Team(name, total);
            ll.add(team);
        }
        ArrayList<Team> fin = getmaxteam(ll);
        for (int i = 0; i < fin.size(); i++) {
            System.out.println("team name is:" + fin.get(i).getName());

        }
    }

    private ArrayList<Team> getmaxteam(ArrayList<Team> list) {
        ArrayList<Team> ll = new ArrayList<Team>();
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            Team team = list.get(i);
            if (team.getPoints() > max) {
                max = team.getPoints();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            Team team = list.get(i);
            if (team.getPoints() == max) {
                ll.add(team);
            }
        }
        return ll;
    }

    public void highestpoints() {
        print(0);
    }

    public void aggressive() {
        print(1);
    }

    public void mvp() {
        print(2);
    }

    public void shot() {
        print(3);
    }

}
