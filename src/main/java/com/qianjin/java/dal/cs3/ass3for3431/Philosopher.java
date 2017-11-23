package com.qianjin.java.dal.cs3.ass3for3431;

/**
 * This is for programming exercise for assignment 3 and the objective of this
 * exercise is to practice using threads in java. according to the requirement
 * of assignment, this class is to be designed as a multithreaded JAVA
 * application that determines whether the solution to a Sudoku puzzle is valid.
 *
 */
public class Philosopher implements Runnable {

    // the default sleep duration
    private final int sleep_duration = 1000;
    private DiningServer server;
    private int no;

    public Philosopher(DiningServer server, int i) {
        this.server = server;
        this.no = i;
    }

    @Override
    public void run() {
        // Once started, program keeps running until terminated explicitly
        try {
            while (!Thread.interrupted()) {
                thinking();
                server.takeForks(no);
                eating();
                server.returnForks(no);
            }
        } catch (InterruptedException ex) {
            System.out.println("quit with interrupted");
        }
    }

    // simulate eating mode,sleep for certain time
    private void eating() throws InterruptedException {
        String str = "philosopher " + no + " is eating." + server.printStates();
        System.out.println(str);
        Thread.sleep(sleep_duration);
    }

    // simulate the thinking mode, sleep for certain time
    private void thinking() throws InterruptedException {
        String str = "philosopher " + no + " is thinking.";
        System.out.println(str);
        Thread.sleep(sleep_duration);
    }

}
