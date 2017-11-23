package com.qianjin.java.sss.java2s.a1101.ass41javayw;


public class Chip {
    private String color;

    // constructor method
    public Chip(String c) {
        color = c;
    }

    // get method
    public String getColor() {
        return color;
    }

    // set method
    public void setColor(String c) {
        color = c;
    }

    // check the color are equal or not.
    public boolean equals(Chip c) {
        if (this.color.equals(c.getColor()))
            return true;
        else
            return false;
    }

    public String toString() {
        String ts = "";
        ts += getColor();
        return ts;
    }
}
