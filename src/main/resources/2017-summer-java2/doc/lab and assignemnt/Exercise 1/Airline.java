/*Lab1, Question 1 CSCI 1101
   Student.java holds information about a student at Dalhousie in CSCI1101 and
   their grades
   June 30, 2017
   Jiaming Han B00726481 
   This is entirely my own work. */

public class Airline {
  private int TotalPlanes;
  private String name;
  private Plane[] allPlanes;
  
  // constructor method.
  public Airline(String Name) {
     name = Name;
     TotalPlanes = 0;
     allPlanes = new Plane[10];
  }
  // get method (to access).
  public String getName(){
    return name;
  }
  
  public int getTotalPassengers() {
    int TotalPassengers = 0;
    for(int i =0; i<TotalPlanes; i++){
     TotalPassengers += allPlanes[i].getNumPassengers();
     }    
    return TotalPassengers;
  }
  
  public int getTotalPlanes() {
    return TotalPlanes;
  }
  
  public Plane[] getAllPlanes() {
    return allPlanes;
  }
  
  // set method (to modify).
  public void setName(String n) {
    name = n;
  }      
  
  public void addPlane(Plane p){  
    if(TotalPlanes < allPlanes.length){
     allPlanes[TotalPlanes] = p;
     TotalPlanes++;
    }
    else {
      System.out. println("Can not add more Planes in this place !");
    }
  }
  // get number of all passengers and number of all seats, and calculate general percentage. 
  public double percentageFull(){
    
      double totalPassengers = 0.0;
      double totalSeats = 0.0;
      
    for(int i =0; i<TotalPlanes; i++) {
      totalPassengers += allPlanes[i].getNumPassengers();
      totalSeats += allPlanes[i].getNumSeats();
    }
      double getPercF  = totalPassengers/totalSeats;
      return getPercF;
  }
  // get toString to collect the information. 
  public String toString(){
    String ts = "";
    ts += "Name of the airline: "+ getName() + ".  total number of planes: "+ getTotalPlanes() +".  total number of passangers: "+ getTotalPassengers();
    return ts;
  }
}  

           
