/*Lab6, Question 1  - demo class CSCI 1101
   StudentDemo.java is a demo program for the Student class. It creates student 
   objects, and compares different students.
   July 2017, 
   Jiaming Han B00726481
   I received help with creating Student objects from my TA but the rest is my
   own work. */

public class EducationDemo {
    public static void main(String[] args){
    
     ComputerScience cs = new ComputerScience(5);
      cs.setName("ComputerScience");
      cs.setInstructor("Jeremy");
      
       // modifying the final grade.
       cs.setFinalGrade(100);
       cs.addGrade(90.0);
       cs.addGrade(71.0);
       cs.addGrade(72.0);
       cs.addGrade(73.0);
       cs.addGrade(100);
       
       // after calculation. we get the real final grade.
       cs.calculateFinalGrade();
       System.out.println(cs.toString());
    
    }
}