/*Lab 5, Question 1 CSCI 1101
 Student.java holds information about a student at Dalhousie in CSCI1101
and their grades
 July 7, 2017
 Jiaming Han B00726481
 This is entirely my own work. */
 
public class Restaurant {

 private String restaurantName;
 private int numSeat;

    // constructor method
    public Restaurant(String rN, int nS){
      restaurantName = rN;
      numSeat = nS;  
    } 
 
    // get metod
    public String getRestaurantName(){
       return restaurantName;
    }
    
    public int getNumSeat(){
       return numSeat;
    } 
    
    // set metod
    public void setRestaurantName(String rN){
      restaurantName = rN;
    } 
    
    public void setNumSeat(int nS){
      numSeat = nS;
    }  
    
    public String toString() {
      String  ts = "";
      ts += "the name of the restaurant is :"+ getRestaurantName()+ ", and there are " + getNumSeat()+" seats in this restaurant.";
      return ts;
    }
}