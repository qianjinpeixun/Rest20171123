package com.qianjin.java.dal.cs3.java2110.lab04ak;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class is designed as a test class for CSCI 2110- Data Structures and
 * Algorithms Laboratory No. 4 Exercise 1
 * 
 * This class can check if the functions of StudentList works well or not.
 * 
 */
public class StudentListDemo {

    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);
        // by default, the fine name is: studentrecords.txt
        System.out.print("Enter the filename to read from: ");
        String filename = keyboard.nextLine();
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        StudentList studentList = new StudentList();
        String id, first, last, email, major, faculty;
        Student stu = null;

        // start to read the file line by line
        while (inputFile.hasNext()) {
            id = inputFile.next();
            first = inputFile.next();
            last = inputFile.next();
            email = inputFile.next();
            major = inputFile.next();
            faculty = inputFile.next();
            // got one student information, create a Student object
            stu = new Student(id, first, last, email, major, faculty);
            // add this object into list
            studentList.add(stu);
        }
        // end of read file
        inputFile.close();

        // start to check the methods
        System.out.println("After reading the record file, the current number of records is: " + studentList.size());
        System.out.println("The current records is as below:");
        studentList.enumerate();
        System.out.println();

        stu = new Student("200999", "MikeTest", "West", "maike.test@gmail.com", "Music", "Arts");
        studentList.add(stu);
        System.out.println("\nAfter add one test student, the current number of records is: " + studentList.size());
        System.out.println("The current records is as below:");
        studentList.enumerate();
        System.out.println();

        System.out.println("\nAll the sutdents taking major: Music are as below:");
        List<Student> list = studentList.getByMajor("Music");
        list.enumerate();
        System.out.println();

        System.out.println("\nAll the sutdents belonging to faculty: Arts are as below:");
        list = studentList.getByFaculty("Arts");
        list.enumerate();
        System.out.println();

        Student student = studentList.getById("200999");
        System.out.println("\nStudent ID number with 200999 is as below:");
        System.out.println(student);

        student = studentList.getByName("MikeTest", "West");
        System.out.println("\nStudent with name MikeTest West as below:");
        System.out.println(student);

        student = studentList.getByEmail("maike.test@gmail.com");
        System.out.println("\nStudent with email: maike.test@gmail.com is as below:");
        if (student != null)
            System.out.println(student);
        else
            System.out.println("not found!");

        studentList.delete(stu);
        System.out.println("\nAfter delete one student, the current number of records is: " + studentList.size());

        student = studentList.getById("200999");
        System.out.println("After delete, try to find student with id 200999, the result is as below:");
        if (student != null)
            System.out.println(student);
        else
            System.out.println("not found!");
    }
}
