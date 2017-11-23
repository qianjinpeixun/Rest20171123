/*Lab 5, Question 1 CSCI 1101
 Student.java holds information about a student at Dalhousie in CSCI1101
 and their grades
 July 7, 2017
 Jiaming Han B00726481
 This is entirely my own work. */
 
public class FastFoodRestaurant extends Restaurant {
  private String slogan;
 
    //construcor method
    public FastFoodRestaurant(String s, int nSeat){
       super(s,nSeat);
    }
    
    //get method (access to superclass).
    public int getNumSeat(){
      return super.getNumSeat();
    } 
    
    public String getSlogan(){
      String slogan = "Best Burgers Ever !";
      return slogan;
    }       
    
    // set mehtod (callling the supclass).
    public void setNumSeat(int nS){
      super.setNumSeat(nS *2);
    }   
    
    public String toString(){
      String  ts= "";
      ts = "Welcome to " + getRestaurantName() +" with "+ getNumSeat() +" seats. "+ getSlogan();
      return ts;
    }
}
      