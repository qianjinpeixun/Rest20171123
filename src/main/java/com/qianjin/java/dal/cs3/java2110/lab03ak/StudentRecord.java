package com.qianjin.java.dal.cs3.java2110.lab03ak;

/**
 * This class is designed for CSCI 2110- Data Structures and Algorithms
 * Laboratory No. 3 Exercise 3
 * 
 * This StudentRecord class holds three attributes: String firstName, String
 * lastName, int bannerID. Add the appropriate constructor, get, set and
 * toString methods.
 * 
 */

public class StudentRecord {

    private String firstName;
    private String lastName;
    private int bannerID;

    // construct method with parameters
    public StudentRecord(String f, String l, int b) {
        this.firstName = f;
        this.lastName = l;
        this.bannerID = b;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBannerID() {
        return bannerID;
    }

    public void setBannerID(int bannerID) {
        this.bannerID = bannerID;
    }

    @Override
    public String toString() {
        return "StudentRecord [firstName=" + firstName + ", lastName=" + lastName + ", bannerID=" + bannerID + "]";
    }

}
