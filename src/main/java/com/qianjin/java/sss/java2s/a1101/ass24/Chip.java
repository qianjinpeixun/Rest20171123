package com.qianjin.java.sss.java2s.a1101.ass24;

public class Chip {

    private String colour;

    public Chip(String c) {
        this.colour = c;
    }

    public boolean equals(Chip c) {
        return c.getColour().equals(colour);
    }

    public String toString() {
        return this.colour;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

}
