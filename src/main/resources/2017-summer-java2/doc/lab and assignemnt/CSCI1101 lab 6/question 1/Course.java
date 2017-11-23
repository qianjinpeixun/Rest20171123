/*Lab6, Question 1 CSCI 1101
   Student.java holds information about a student at Dalhousie in CSCI1101 and
   their grades
   July 10, 2017
   Jiaming Han B00726481
   This is entirely my own work. */

public abstract class Course{
 private String CourseName;
 private String instructor;
 private double finalGrade;
 
    
    //get method
    public String getName(){
      return CourseName;
    }
    
    public double getFinalGrade(){
      return finalGrade ;
    }
    
    public String getInstructor(){
      return instructor;
    }
    
    //set method
    public void setName(String n){
      CourseName = n;
    }
    
    public void setFinalGrade(double fg){
      finalGrade = fg;
    
    }
    public void setInstructor(String i){
      instructor = i;
    }
    // abstract method
    public abstract void calculateFinalGrade ();
    
    public String toString(){
      String ts = "" ;
      ts += "Welcome to study " +getName() + " with the instructor "+ getInstructor() +". the final grade of this course is: " + getFinalGrade();
      return ts;
    }
}