package com.qianjin.java.dal.cs3.java2110.lab04ak;

/**
 * This class is designed as a class for CSCI 2110- Data Structures and
 * Algorithms Laboratory No. 4 Exercise 1
 * 
 */
public class Student {

    // in order to hold student's information
    private String id;
    private String firatName;
    private String lastName;
    private String email;
    private String major;
    private String faculty;

    // constructor
    public Student(String id, String firatName, String lastName, String email, String major, String faculty) {
        this.id = id;
        this.firatName = firatName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.faculty = faculty;
    }

    // in order to determine if one student equals another one
    public boolean equals(Student other) {
        return (id.equals(other.getId()) && firatName.equals(other.getFiratName())) && lastName.equals(other.getLastName()) && email.equals(other.getEmail())
                && major.equals(other.getMajor()) && faculty.equals(other.getFaculty());
    }

    public String toString() {
        return "Student [id=" + id + ", firatName=" + firatName + ", lastName=" + lastName + ", email=" + email + ", major=" + major + ", faculty=" + faculty + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFiratName() {
        return firatName;
    }

    public void setFiratName(String firatName) {
        this.firatName = firatName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

}
