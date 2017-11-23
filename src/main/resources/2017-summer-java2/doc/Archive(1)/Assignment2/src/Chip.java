/*Assignment2, Question 1 CSCI 1101
  Game.java game is a grid.
   July 12, 2017
   Yiping Liang B00744822
   This is entirely my own work. */
public class Chip {

    private final String colour;

    public Chip(String c) {
        this.colour = c;
    }

    public String getColour() {
        return colour;
    }

    public boolean equals(Chip c) {//determine whether two Chip objects are equivalent
        boolean same = false;
        same = c.getColour().equalsIgnoreCase(colour);
        return same;
    }

    public String toString() {//representing the colour of the current Chip. 
        return String.valueOf(this.colour.toUpperCase().charAt(0));
    }

}
