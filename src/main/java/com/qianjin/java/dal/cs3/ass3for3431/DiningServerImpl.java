package com.qianjin.java.dal.cs3.ass3for3431;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class is designed to be a implementation for DiningServer interface
 * which solves the dining philosophers' problem with two methods:takeForks and
 * returnForks.
 * 
 */
public class DiningServerImpl implements DiningServer {

    // the default number of philosopher is 5
    public final static int NUM_OF_PHILS = 5;
    // Using a reentrant lock (available through Java.util.concurrent.locks api)
    // which allows a thread to reacquire the same lock multiple times without
    // any issue).
    private ReentrantLock lock;
    // condition variable for each philosopher rather than each fork. the basic
    // idea is that if the left and right philosopher do not eat now, the
    // current philosopher can eat.
    private Condition[] conditions = new Condition[NUM_OF_PHILS];
    // a variable to indicate if the philosopher is eating
    private boolean[] eating;

    /*
     * This is a test method, in order to print out the current status of each
     * philosopher.
     */
    public String printStates() {
        String ret = "";
        for (int i = 0; i < NUM_OF_PHILS; i++) {
            ret = i + "=" + eating[i] + "," + ret;
        }
        return "";
    }

    /*
     * Constructor
     */
    public DiningServerImpl() {
        // create a lock in order to lock the whole table.
        lock = new ReentrantLock();
        // by default, every philosopher is not eating
        eating = new boolean[NUM_OF_PHILS];
        for (int i = 0; i < NUM_OF_PHILS; i++) {
            eating[i] = false;
            conditions[i] = lock.newCondition();
        }
    }// end of Constructor

    // get the left philosopher's number
    private int getright(int pNumber) {
        if (pNumber == (NUM_OF_PHILS - 1))
            return 0;
        return (pNumber + 1);
    }

    // get the right philosopher's number
    private int getleft(int pNumber) {
        if (pNumber == 0)
            return (NUM_OF_PHILS - 1);
        return (pNumber - 1);
    }

    // called by a philosopher when he/she wants to eat
    public void takeForks(int pNumber) {
        String str = "philosopher " + pNumber + " is hungry." + printStates();
        System.out.println(str);
        // start to try to lock
        lock.lock();
        try {
            // if left or right philosopher is eating, suspend
            while (eating[getleft(pNumber)] || eating[getright(pNumber)]) {
                conditions[pNumber].await();
            }
            // if the left and right philosopher do not eat, then can enter
            // eating mode
            eating[pNumber] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    // called by a philosopher when he/she are done eating
    public void returnForks(int pNumber) {

        lock.lock();
        try {
            eating[pNumber] = false;
            // notify the left and right philosopher's thread, if there is any
            // suspend for eating, can resume them
            conditions[getleft(pNumber)].signal();
            conditions[getright(pNumber)].signal();
        } finally {
            String str = "philosopher " + pNumber + " is done eating." + printStates();
            System.out.println(str);
            lock.unlock();
        }
    }
}
