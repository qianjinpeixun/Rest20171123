package com.qianjin.java.sss.java2s.a1101.lab07;

import java.util.ArrayList;

public abstract class WordList {

    private ArrayList<String> list;

    public WordList() {
        list = new ArrayList<String>();
    }

    // use a shallow copy to return the internal list
    public ArrayList<String> getList() {
        return list;
    }

    // use a deep copy
    public void setList(ArrayList<String> l) {
        list = new ArrayList<String>();
        for (String s : l) {
            list.add(s);
        }
    }

    // for comparing two WordList objects
    public abstract boolean compare(WordList w);

}
