/*
 * Assignment 2 Question 1 CSCI 2110
 * 
 * PlayerRecord.java
 * 
 * Oct 23rd, 2017 Yiping
 * 
 * Liang B00744822 This is entirely my own work.
 */


public class PlayerRecord {

    private String name;
    private String position;
    private String teamname;
    private int game;
    private int goalscore;
    private int assists;
    private int penalties;
    private int shots;
    private int winninggoals;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public int getGame() {
        return game;
    }

    public void setGame(int game) {
        this.game = game;
    }

    public int getGoalscore() {
        return goalscore;
    }

    public void setGoalscore(int goalscore) {
        this.goalscore = goalscore;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public int getShots() {
        return shots;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public int getWinninggoals() {
        return winninggoals;
    }

    public void setWinninggoals(int winninggoals) {
        this.winninggoals = winninggoals;
    }

    public PlayerRecord() {
    }

    public String toString() {
        return "name=" + name + ",position=" + position + ",teamname=" + teamname + ",game=" + game + ",goalscore=" + goalscore + ",assists=" + assists + ",penalties=" + penalties
                + ",shots=" + shots + ",winninggoals=" + winninggoals;
    }

}
