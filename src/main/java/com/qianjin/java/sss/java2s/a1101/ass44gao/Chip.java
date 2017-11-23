package com.qianjin.java.sss.java2s.a1101.ass44gao;
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
