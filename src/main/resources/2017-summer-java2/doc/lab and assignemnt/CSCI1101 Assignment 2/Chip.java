/*Assigment2, Question 1 CSCI 1101
 Student.java holds information about a student at Dalhousie in CSCI1101
and
 their grades
 July 9, 2017
 Jiaming Han B00726481
 This is entirely my own work. */

public class Chip {
   private String color;
   
   //constructor method
   public Chip(String c){
      color = c;
   }
   
   // get method
   public String getColor(){
      return color;
   }
   
   // set method
   public void setColor (String c){
      color = c;
   }   
   // check the color are equal or not.
   public boolean equals(Chip c){
     if(this.color.equals(c.getColor()))
      return true;
     else 
      return false;  
   }
   
   public String toString(){
      String ts = "";
      ts += getColor();
      return ts;
   }
}
