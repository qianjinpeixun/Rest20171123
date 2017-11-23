/*Lab 5, Question 2 CSCI 1101
 Student.java holds information about a student at Dalhousie in CSCI1101
and their grades
 July 7, 2017
 Jiaming Han B00726481
 This is entirely my own work. */
 
public class HighSchool extends School{
 private String principalName;
 private int numTeachers;
 
   // constructor method
   public HighSchool(String name, int numS, String p, int numT){
     super(name);
     super.setNumStudent(numS);
     principalName = p;
     numTeachers = numT;
   }
    
   // get metod
   public String getPrincipalName(){
      return principalName; 
   }
    
   public int getNumTeachers(){
      return numTeachers;
   }     
   
   //set method
    public void setPrincipalName(String p){
      principalName = p;
    }  
       
    public void setNumTeachers(int nt){
      numTeachers = nt;
    } 
    //getting the ratio of teachers to students.
    public double calculateRatio(){
      double ratio = (double)numTeachers/getNumStudent();
      return ratio;
    }
    
    public String toString() {
      String  ts = super.toString();
      ts += ". \nAlso, the principal of this school is : " + getPrincipalName() + ", and the ratio of teachers to students is : "+ calculateRatio();
      return ts;
    }
}    