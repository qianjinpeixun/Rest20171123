
import java.io.*;
import java.util.*;

public class NHLListDemo {

    public static void main(String[] args) throws Exception, FileNotFoundException {
        InputStreamReader reader;
        BufferedReader buffer;
        String line;
        reader = new InputStreamReader(new FileInputStream("nhlstats.txt"), "utf-8");
        buffer = new BufferedReader(reader);
        line = buffer.readLine();
        List<PlayerRecord> playerlist = new List<PlayerRecord>();

        while (line != null) {// begin to read file
            StringTokenizer token = new StringTokenizer(line, "\t");
            PlayerRecord player = new PlayerRecord(token.nextToken(), token.nextToken(), token.nextToken(), Integer.valueOf(token.nextToken()), Integer.valueOf(token.nextToken()),
                    Integer.valueOf(token.nextToken()), Integer.valueOf(token.nextToken()), Integer.valueOf(token.nextToken()), Integer.valueOf(token.nextToken()));
            playerlist.add(player);
            line = buffer.readLine();
        }
        buffer.close();
        reader.close();

        // begin to print the result
        System.out.println("NHL Results Summary");
        System.out.println();
        NHLStats stat = new NHLStats(playerlist);
        System.out.println("Players with highest points and their teams:");
        stat.highestpoints();
        System.out.println();

        System.out.println("Most aggressive players, their teams and their positions:");
        stat.aggressive();
        System.out.println();

        System.out.println("Most valuable players and their teams:");
        stat.mvp();
        System.out.println();

        System.out.println("Most promising players and their teams:");
        stat.shot();
        System.out.println();

        System.out.println("Teams that had the most number of penalty minutes:");
        stat.team1();
        System.out.println();

        System.out.println("Teams that had the most number of game winning goals:");
        stat.team2();
        System.out.println();

    }

}
