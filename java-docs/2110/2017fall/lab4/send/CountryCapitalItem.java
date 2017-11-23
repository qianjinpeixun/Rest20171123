
/**
 * This class is designed as a class for CSCI 2110- Data Structures and
 * Algorithms Laboratory No. 4 Exercise 3
 * 
 */
public class CountryCapitalItem {

    private String country;
    private String capital;

    // constructor
    public CountryCapitalItem(String country, String capital) {
        this.country = country;
        this.capital = capital;
    }

    public String toString() {
        return "CountryCapitalItem [country=" + country + ", capital=" + capital + "]";
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

}
