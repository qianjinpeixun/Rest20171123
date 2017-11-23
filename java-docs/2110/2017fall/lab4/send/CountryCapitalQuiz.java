
/**
 * This class is designed as a test class for CSCI 2110- Data Structures and
 * Algorithms Laboratory No. 4 Exercise 3
 * 
 * This class provide a geography quiz that tests kids on their knowledge of
 * countries and their capitals.
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class CountryCapitalQuiz {

    public static void main(String[] args) throws FileNotFoundException {
        // the file is from the lab link resource
        File file = new File("CountriesCapitals.txt");
        Scanner inputFile = new Scanner(file);
        Scanner kb = new Scanner(System.in);

        String country, capital;
        // Store the Country-Capital pairs as items in an unordered list
        List<CountryCapitalItem> list = new List<CountryCapitalItem>();

        while (inputFile.hasNext()) {
            country = inputFile.nextLine();
            capital = inputFile.nextLine();
            CountryCapitalItem item = new CountryCapitalItem(country, capital);
            list.add(item);
        }

        Random random = new Random();
        int minimum, maximum, range;

        boolean quit = false;
        System.out.println("Welcome to the Country-Capital Quiz");
        System.out.println("Play?");
        String play = kb.nextLine();
        if (!play.equals("Yes")) {
            System.out.println("Game over.");
            return;
        }

        while (!quit) {

            // generate a random number for country or city
            minimum = 0;
            maximum = 1;
            range = maximum - minimum + 1;
            int type = random.nextInt(range) + minimum;

            // generate a random number to randomly select a country or a city
            minimum = 0;
            maximum = list.size() - 1;
            range = maximum - minimum + 1;
            int index = random.nextInt(range) + minimum;

            CountryCapitalItem item = list.first();
            if (item != null) {
                for (int i = 0; i < index; i++) {
                    item = list.next();
                }
            }
            // got the correct country name and city name
            String countryName = item.getCountry();
            String capitalName = item.getCapital();

            // start to ask a question that matches a country to a capital or a
            // capital to a country according to type
            // guest capital
            if (type == 0) {
                System.out.println("What is the capital of " + countryName + "?");
                String cap = kb.nextLine();
                if (capitalName.equals(cap)) {
                    System.out.println("Correct. Play?");
                    play = kb.nextLine();
                    if (!play.equals("Yes")) {
                        quit = true;
                    } else {
                        quit = false;
                    }
                } else {
                    System.out.println("Incorrect. The correct answer is " + capitalName + ". Play?");
                    play = kb.nextLine();
                    if (!play.equals("Yes")) {
                        quit = true;
                    } else {
                        quit = false;
                    }
                }
            } else {
                System.out.println("What country has " + capitalName + " as its capital ?");
                String cap = kb.nextLine();
                if (countryName.equals(cap)) {
                    System.out.println("Correct. Play?");
                    play = kb.nextLine();
                    if (!play.equals("Yes")) {
                        quit = true;
                    } else {
                        quit = false;
                    }
                } else {
                    System.out.println("Incorrect. The correct answer is " + countryName + ". Play?");
                    play = kb.nextLine();
                    if (!play.equals("Yes")) {
                        quit = true;
                    } else {
                        quit = false;
                    }
                }
            }
        }
        System.out.println("Game over.");
    }

}
