package com.qianjin.java.dal.cs3.java2110.lab03ak;

/**
 * This class is a test class designed for CSCI 2110- Data Structures and
 * Algorithms Laboratory No. 3 Exercise 5
 * 
 */
public class PrintQueueTester {

    public static void main(String[] args) {

        // create a queue
        PrintQueue pq = new PrintQueue();
        // add some tasks
        pq.lpr("swilliams", 309);
        pq.lpr("ronaldinho", 300);
        pq.lpr("marionjones", 312);
        pq.lpr("swilliams", 267);
        pq.lpr("davidh", 135);
        pq.lpr("ronaldinho", 301);

        System.out.println("After add some elements, the current printerQueue is:");
        pq.lpq();
        // removes the first entry from the queue
        pq.lprm(309);
        System.out.println("\nAfter removes the first entry from the queue, the current printerQueue is:");
        pq.lpq();
        // removes all entries of ronaldinho from the queue
        pq.lprmAll("ronaldinho");
        System.out.println("\nAfter removes all entries of ronaldinho from the queue, the current printerQueue is:");
        pq.lpq();
    }
}
