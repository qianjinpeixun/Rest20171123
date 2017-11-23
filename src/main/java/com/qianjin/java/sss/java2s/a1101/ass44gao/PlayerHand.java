package com.qianjin.java.sss.java2s.a1101.ass44gao;

import java.util.ArrayList;

public class PlayerHand extends Pile {

    public void shuffle() {

    }

    public Card draw() {
        Card c = getPile().getFrontData();
        getPile().removeFront();
        return c;
    }

    public int size() {
        return getPile().size();
    }

    public void clear() {
        getPile().clear();
    }

    public void addAll(LinkedList list) {
        getPile().addAll(list);
    }
}
