/*
 * Assignment 2 Question 1 CSCI 2110
 * 
 * PlayerTeam.java in order to hold team for each players
 * 
 * Oct 23rd, 2017 Yiping
 * 
 * Liang B00744822 This is entirely my own work.
 */

package com.qianjin.java.dal.cs3.java2110.ass2gc;

public class PlayerTeam {

    private String name;
    private int penalties;
    private int winninggoals;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public int getWinninggoals() {
        return winninggoals;
    }

    public void setWinninggoals(int winninggoals) {
        this.winninggoals = winninggoals;
    }

    public PlayerTeam() {
    }

    public String toString() {
        return "name=" + name + ",penalties=" + penalties + ",winninggoals=" + winninggoals;
    }

}
