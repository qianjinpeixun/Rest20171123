/*Lab4, Question 2 CSCI 1101
   Student.java holds information about a student at Dalhousie in CSCI1101 and
   their grades
   June 30, 2017
   Jiaming Han B00726481 
   This is entirely my own work. */

public class Book {
  private int numPages;
  //constructor method
  public Book(){
  }
  // set method (to modify).
  public void setPages(int p){
  numPages = p;
  }
  // get method (to access).
  public int getPages(){
  return numPages;
  }
}