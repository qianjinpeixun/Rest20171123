/*Lab 5, Question 2 - demo class CSCI 1101
 StudentDemo.java is a demo program for the Student class. It creates
student objects, and compares different students.
 July 7, 2017
 Jiaming Han B00726481
 I received help with creating Student objects from my TA but the rest is
my own work. */

public class EducationDemo{
  public static void main(String[] args){
    HighSchool high = new HighSchool("CS-learning highSchool ", 999, "Jiaming Han", 1);
    
       high.setName("Microsoft high-Scool");
       high.setNumStudent(500);
       high.setPrincipalName("Bill Gates");
       high.setNumTeachers(25);

       System.out.println(high.toString());
  }
}    
    