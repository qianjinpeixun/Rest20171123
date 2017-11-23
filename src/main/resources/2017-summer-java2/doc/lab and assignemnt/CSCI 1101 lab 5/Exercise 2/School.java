/*Lab 5, Question 2 CSCI 1101
 Student.java holds information about a student at Dalhousie in CSCI1101
and their grades
 July 7, 2017
 Jiaming Han B00726481
 This is entirely my own work. */
 
public class School {
 private int numStudent;
 private String name;
 
   // constructor method
   public School(String name){
      numStudent =0;
      this.name = name;
   }
    
   // get metod
   public int getNumStudent(){
      return numStudent; 
   }
    
   public String getName(){
      return name;
   }     
   
   //set method
    public void setNumStudent(int n){
      numStudent = n;
    }  
       
    public void setName(String n){
      name = n;
    } 

    public String toString() {
      String  ts = "";
      ts += "Welcome to :"+ getName()+ " there are " + getNumStudent()+" students in this school";
      return ts;
    }
}    