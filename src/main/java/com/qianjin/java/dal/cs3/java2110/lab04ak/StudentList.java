package com.qianjin.java.dal.cs3.java2110.lab04ak;

/**
 * This class is designed as a class for CSCI 2110- Data Structures and
 * Algorithms Laboratory No. 4 Exercise 1
 * 
 * This class can store and manage information about students taking courses at
 * a university.
 * 
 */
public class StudentList {

    // an unordered list of student records
    private List<Student> students;

    public StudentList() {
        // create an empty record
        students = new List<Student>();
    }

    /**
     * Add a student record to the list
     * 
     * @param stu
     *            student will be added into list
     */
    public void add(Student stu) {
        students.add(stu);
    }

    /**
     * Delete a student record from the list
     * 
     * @param stu
     *            student will be removed from the list
     */
    public void delete(Student stu) {
        students.remove(stu);
    }

    public boolean isEmpty() {
        return students.isEmpty();
    }

    public boolean contains(Student stu) {
        return students.contains(stu);
    }

    public void enumerate() {
        students.enumerate();
    }

    public int size() {
        return students.size();
    }

    /**
     * Display records of all the students taking a specific major
     * 
     * @param major
     *            query string
     * @return List if no students can be found, the list will be empty
     */
    public List<Student> getByMajor(String major) {
        List<Student> list = new List<Student>();
        Student stu = students.first();
        while (stu != null) {
            if (stu.getMajor().equals(major)) {
                list.add(stu);
            }
            stu = students.next();
        }
        return list;
    }

    /**
     * Display records of all students belonging to a particular faculty
     * 
     * @param faculty
     *            query string
     * @return List if no students can be found, the list will be empty
     */
    public List<Student> getByFaculty(String faculty) {
        List<Student> list = new List<Student>();
        Student stu = students.first();
        while (stu != null) {
            if (stu.getFaculty().equals(faculty)) {
                list.add(stu);
            }
            stu = students.next();
        }
        return list;
    }

    /**
     * Search for a student’s record given an ID number
     * 
     * @param id
     *            query string
     * @return Student if not found, null will be returned
     */
    public Student getById(String id) {

        Student stu = students.first();
        while (stu != null) {
            if (stu.getId().equals(id)) {
                return stu;
            }
            stu = students.next();
        }
        return null;
    }

    /**
     * Search for a student’s record given the last and first names
     * 
     * @param first
     *            first name
     * @param last
     *            last name
     * @return Student if not found, null will be returned
     */
    public Student getByName(String first, String last) {

        Student stu = students.first();
        while (stu != null) {
            if (stu.getFiratName().equals(first) && stu.getLastName().equals(last)) {
                return stu;
            }
            stu = students.next();
        }
        return null;
    }

    /**
     * Search for a student’s record given the email address
     * 
     * @param email
     *            query string
     * @return Student if not found, null will be returned
     */
    public Student getByEmail(String email) {

        Student stu = students.first();
        while (stu != null) {
            if (stu.getEmail().equals(email)) {
                return stu;
            }
            stu = students.next();
        }
        return null;
    }
}
