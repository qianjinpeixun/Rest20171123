package com.qianjin.java.sss.java2s.a1101.lab07;

import java.util.ArrayList;

public class AlphabetizedList extends WordList {

    public AlphabetizedList() {
        super();
    }

    public AlphabetizedList(ArrayList<String> l) {
        super();
        setList(l);
        alphabetize();
    }

    public boolean compare(WordList w) {
        String word1 = getList().get(0);
        String word2 = w.getList().get(0);
        if (word1.compareTo(word2) < 0) {
            return true;
        } else if (word1.compareTo(word2) > 0) {
            return false;
        } else
            return true;
    }

    public void alphabetize() {
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < getList().size(); i++) {
            String ss = getList().get(i);
            int position = 0;
            boolean last = false;
            if (i == 0)
                temp.add(ss);
            else {
                last = false;
                for (int j = 0; j < temp.size(); j++) {
                    String t = temp.get(j);
                    if (ss.compareTo(t) < 0) {
                        position = j;
                        last = false;
                        break;
                    } else {
                        last = true;
                    }
                }
                if (last == false) {
                    temp.add(position, ss);
                } else {
                    temp.add(ss);
                }

            }
        }
        setList(temp);
    }

    public void merge(AlphabetizedList al) {
        ArrayList<String> n = new ArrayList<String>();
        for (String s : getList()) {
            n.add(s);
        }
        for (String s : al.getList()) {
            n.add(s);
        }
        setList(n);
        alphabetize();
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < getList().size(); i++) {
            s = s + getList().get(i) + ",";
        }
        s = s.substring(0, s.length() - 1);
        return s;
    }
}
