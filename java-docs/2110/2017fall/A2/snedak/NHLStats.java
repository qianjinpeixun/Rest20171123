
import java.util.ArrayList;

/**
 * 
 * This class is designed for CSCI 2110 Data Structures and Algorithms - Fall
 * 2017 Assignment No. 2 Exercise 1.
 *
 */
public class NHLStats {

    // An unordered list of PlayerRecord objects
    private List<PlayerRecord> playerlist;

    // constructor, create an empty list
    public NHLStats() {
        playerlist = new List<PlayerRecord>();
    }

    // add one player
    public void add(PlayerRecord r) {
        playerlist.add(r);
    }

    /**
     * Method that displays the player’s name with the maximum number of points
     * and his team’s name. If more than one player has the largest number of
     * points, display all the players and their teams.
     */
    public String getPlayersWithHighestPoint() {
        // First step, getting the maximum score
        if (playerlist.isEmpty())
            return "";
        PlayerRecord playRecord = playerlist.first();
        int maximum = playRecord.getScore();
        while ((playRecord = playerlist.next()) != null) {
            if (playRecord.getScore() > maximum) {
                maximum = playRecord.getScore();
            }
        }
        // Second step, print the name with highest score
        String ret = "";
        playRecord = playerlist.first();
        while ((playRecord = playerlist.next()) != null) {
            if (playRecord.getScore() == maximum) {
                ret = ret + playRecord.getName() +","+playRecord.getTeam()+ "\r\n";
            }
        }
        return ret.substring(0, ret.length() - 1);
    }

    /**
     * Method that displays the name of the player who had the maximum number of
     * penalty minutes, his team name and his position. If more than one player
     * has the largest number of points, display all the players and their
     * teams.
     */
    public String getMostAggressivePlayers() {
        // First step, getting the maximum penalty minutes
        if (playerlist.isEmpty())
            return "";
        PlayerRecord playRecord = playerlist.first();
        int maximum = playRecord.getPim();
        while ((playRecord = playerlist.next()) != null) {
            if (playRecord.getPim() > maximum) {
                maximum = playRecord.getPim();
            }
        }
        String ret = "";
        // Second step, print the name with maximum number of penalty minutes
        playRecord = playerlist.first();
        while ((playRecord = playerlist.next()) != null) {
            if (playRecord.getPim() == maximum) {
                ret = ret + playRecord.getName() + "," + playRecord.getTeam() + "," + playRecord.getPos() + "\r\n";

            }
        }
        return ret.substring(0, ret.length() - 1);
    }

    /**
     * Method that displays the name of the player who scored the most number of
     * game winning goals and his team’s name. If more than one player has the
     * largest number of points, display all the players and their teams.
     */
    public String getMostValuablePlayers() {
        // First step, getting the maximum penalty minutes
        if (playerlist.isEmpty())
            return "";
        PlayerRecord playRecord = playerlist.first();
        int maximum = playRecord.getGwg();
        while ((playRecord = playerlist.next()) != null) {
            if (playRecord.getGwg() > maximum) {
                maximum = playRecord.getGwg();
            }
        }
        String ret = "";
        // Second step, print the name with the most number of game winning
        // goals
        playRecord = playerlist.first();
        while ((playRecord = playerlist.next()) != null) {
            if (playRecord.getGwg() == maximum) {
                ret = ret + playRecord.getName()+","+playRecord.getTeam() + "\r\n";
            }
        }
        return ret.substring(0, ret.length() - 1);
    }

    /*
     * Method that displays the name of the player who took the most number of
     * shots on goal and their team names.If more than one player has the
     * largest number of points, display all the players and their teams.
     */
    public String getPromisingPlayers() {
        // First step, getting the maximum penalty minutes
        if (playerlist.isEmpty())
            return "";
        PlayerRecord playRecord = playerlist.first();
        int maximum = playRecord.getSog();
        while ((playRecord = playerlist.next()) != null) {
            if (playRecord.getSog() > maximum) {
                maximum = playRecord.getSog();
            }
        }
        String ret = "";
        // Second step, print the name with the most number of shots on goal
        playRecord = playerlist.first();
        while ((playRecord = playerlist.next()) != null) {
            if (playRecord.getSog() == maximum) {
                ret = ret + playRecord.getName() + "," + playRecord.getTeam() + "\r\n";
            }
        }
        return ret.substring(0, ret.length() - 1);
    }

    /**
     * Get the all team name with no duplication,an ArrayList to hold items
     * belonging to a team,
     * 
     * @return arraylist including all team name
     */
    private ArrayList<NHLTeam> getTeamName() {
        ArrayList<String> teamnameList = new ArrayList<String>();
        ArrayList<NHLTeam> teamList = new ArrayList<NHLTeam>();
        if (playerlist.isEmpty())
            return teamList;
        PlayerRecord playRecord = playerlist.first();
        while ((playRecord = playerlist.next()) != null) {
            if (!teamnameList.contains(playRecord.getTeam())) {
                teamnameList.add(playRecord.getTeam());
            }
        }
        for(int i=0;i<teamnameList.size();i++){
            teamList.add(new NHLTeam(teamnameList.get(i)));
        }
        return teamList;
    }

    /**
     * Method that displays the name of the team that had the most penalty
     * minutes (sum of all penalty minutes of all players in that team).If more
     * than one player has the largest number of points, display all the players
     * and their teams.
     */
    public String getTeamWithMostPenaltyMinutes() {
        ArrayList<NHLTeam> teamList = getTeamName();
        if (playerlist.isEmpty())
            return "";
        String ret = "";
        // First step, calculate all team's pim score
        PlayerRecord playRecord = playerlist.first();
        while ((playRecord = playerlist.next()) != null) {
            for (int i = 0; i < teamList.size(); i++) {
                NHLTeam team = (NHLTeam) teamList.get(i);
                if (team.getName().equals(playRecord.getTeam())) {
                    team.setPim(team.getPim() + playRecord.getPim());
                    continue;
                }
            }
        }

        // Second step, find and print the highest pim score
        int maximum = teamList.get(0).getPim();
        for (int i = 0; i < teamList.size(); i++) {
            if (teamList.get(i).getPim() > maximum) {
                maximum = teamList.get(i).getPim();
            }
        }

        // Third step, find the team name
        for (int i = 0; i < teamList.size(); i++) {
            if (teamList.get(i).getPim() == maximum) {
                ret = ret + teamList.get(i).getName() + "\r\n";
            }
        }
        return ret.substring(0, ret.length() - 1);
    }

    /*
     * Method that displays the name of the team that had the most number of
     * game winning goals.If more than one player has the largest number of
     * points, display all the players and their teams.
     */
    public String getTeamWithMostGameWinningGoals() {
        String ret = "";
        ArrayList<NHLTeam> teamList = getTeamName();
        if (playerlist.isEmpty())
            return ret;
        // First step, calculate all team's gwg score
        PlayerRecord playRecord = playerlist.first();
        while ((playRecord = playerlist.next()) != null) {
            for (int i = 0; i < teamList.size(); i++) {
                NHLTeam team = (NHLTeam) teamList.get(i);
                if (team.getName().equals(playRecord.getTeam())) {
                    team.setGwg(team.getGwg() + playRecord.getGwg());
                    continue;
                }
            }
        }
        // Second step, find and print the highest gwg score
        int maximum = teamList.get(0).getGwg();
        int index = 0;
        for (int i = 0; i < teamList.size(); i++) {
            if (teamList.get(i).getGwg() > maximum) {
                maximum = teamList.get(i).getGwg();
                index = i;
                ;
            }
        }

        // Third step, find the team name
        for (int i = 0; i < teamList.size(); i++) {
            if (teamList.get(i).getGwg() == maximum) {
                ret = ret + teamList.get(i).getName() + "\r\n";
            }
        }
        return ret.substring(0, ret.length() - 1);
    }

}
