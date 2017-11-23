package com.qianjin.java.sss.java2s.a1101.ass45zzz;

public class Chip {

    // after set value in constructor, the colour should not be modified
    private final String colour;

    // The constructor initialize the colour of the Chip
    public Chip(String colour) {
        this.colour = colour.toLowerCase();
    }

    public String getColour() {
        return colour;
    }

    // The equals method determine whether two Chip objects are equivalent
    // If the colour is the same, two Chip objects are equivalent.
    public boolean equals(Chip chip) {
        if (chip.getColour().toLowerCase().equals(colour))
            return true;
        else
            return false;
    }

    // return a String representing the colour of the current Chip.
    public String toString() {
        if (colour.toLowerCase().equals("red"))
            return "R";
        else
            return "Y";
    }

}
