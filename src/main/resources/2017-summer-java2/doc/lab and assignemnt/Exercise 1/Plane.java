/*Lab4, Question 1 CSCI 1101
   Student.java holds information about a student at Dalhousie in CSCI1101 and
   their grades
   June 30, 2017
   Jiaming Han B00726481 
   This is entirely my own work. */
   
public class Plane {
  private String PlaneName;
  private int numSeats;
  private int numPassengers;
  
  // constructor method
  public Plane(String name, int seat) {
    numPassengers = 0;
    numSeats = seat;
    PlaneName = name;
  }
  // get method (to access).
  public String getPlaneName() {
    return PlaneName;
  }  
  
  public int getNumSeats() {
    return numSeats;
  }
  
  public int getNumPassengers() {
     return numPassengers;
  }
  // set emthod (to modify).
  public void setNumSeats(int num) {
     numSeats = num;
  }
  
  public void addPassengers(int num){
      numPassengers += num;
  }
  public boolean hasMoreSeats (Plane p){
    if (numSeats >= p.getNumSeats()) 
       return true;
    else 
       return false;
  } 
}