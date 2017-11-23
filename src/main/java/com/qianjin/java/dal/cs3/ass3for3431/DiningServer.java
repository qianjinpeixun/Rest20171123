package com.qianjin.java.dal.cs3.ass3for3431;

/**
 * DiningServer.java This class contains the methods called by the philosophers.
 **/

public interface DiningServer {
    // called by a philosopher when he/she wants to eat
    public void takeForks(int pNumber);

    // called by a philosopher when he/she are done eating
    public void returnForks(int pNumber);

    // This is a method in order to test the output status
    public String printStates();
}
