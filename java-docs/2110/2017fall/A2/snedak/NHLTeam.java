
/**
 * This class is designed in order to store the attributes of each team which
 * helps to search and get answers specific to a team.
 *
 */
public class NHLTeam {

    private String name;
    private int pim;
    private int gwg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPim() {
        return pim;
    }

    public void setPim(int pim) {
        this.pim = pim;
    }

    public int getGwg() {
        return gwg;
    }

    public void setGwg(int gwg) {
        this.gwg = gwg;
    }

    @Override
    public String toString() {
        return "NHLTeam [name=" + name + ", pim=" + pim + ", gwg=" + gwg + "]";
    }

    public NHLTeam(String name, int pim, int gwg) {
        super();
        this.name = name;
        this.pim = pim;
        this.gwg = gwg;
    }

    public NHLTeam(String name) {
        super();
        this.name = name;
        this.pim = 0;
        this.gwg = 0;
    }

}
