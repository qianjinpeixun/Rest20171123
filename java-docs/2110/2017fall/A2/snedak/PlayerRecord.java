
/**
 * This class has all the instance variables for one player (Name, Position,
 * Team, GP, G, A, PIM, SOG, GWG)
 *
 */
public class PlayerRecord {

    private String name;
    private String pos;
    private String team;
    private int gp;
    private int g;
    private int a;
    private int pim;
    private int sog;
    private int gwg;
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public PlayerRecord(String name, String pos, String team, int gp, int g, int a, int pim, int sog, int gwg, int score) {
        super();
        this.name = name;
        this.pos = pos;
        this.team = team;
        this.gp = gp;
        this.g = g;
        this.a = a;
        this.pim = pim;
        this.sog = sog;
        this.gwg = gwg;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGp() {
        return gp;
    }

    public void setGp(int gp) {
        this.gp = gp;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getPim() {
        return pim;
    }

    public void setPim(int pim) {
        this.pim = pim;
    }

    public int getSog() {
        return sog;
    }

    public void setSog(int sog) {
        this.sog = sog;
    }

    public int getGwg() {
        return gwg;
    }

    public void setGwg(int gwg) {
        this.gwg = gwg;
    }

    @Override
    public String toString() {
        return "PlayerRecord [name=" + name + ", pos=" + pos + ", team=" + team + ", gp=" + gp + ", g=" + g + ", a=" + a + ", pim=" + pim + ", sog=" + sog + ", gwg=" + gwg + "]";
    }

}
