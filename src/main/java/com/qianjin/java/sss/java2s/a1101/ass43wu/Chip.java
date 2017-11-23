package com.qianjin.java.sss.java2s.a1101.ass43wu;

public class Chip {
	private String colour;

    public Chip(String c) {
        this.colour = c;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean equals(Chip c) {
        if (c.getColour().equals(this.colour))
            return true;
        else
            return false;
    }
    
    public String toString(){
        return this.colour;
    }

}


