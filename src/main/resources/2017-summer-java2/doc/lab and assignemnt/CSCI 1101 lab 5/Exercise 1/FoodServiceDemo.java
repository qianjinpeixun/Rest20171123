/*Lab 5, Question 1 - demo class CSCI 1101
 StudentDemo.java is a demo program for the Student class. It creates
student
 objects, and compares different students.
 July 7, 2017
 Jiaming Han B00726481
 I received help with creating Student objects from my TA but the rest is
my
 own work. */
public class FoodServiceDemo{
  public static void main(String[] args){
    FastFoodRestaurant Fr1 = new FastFoodRestaurant("Tim Hortons", 20);
    
      //modifying the number of seat to become 2 times.
      Fr1.setNumSeat(20);
      Fr1.setRestaurantName("BigBoy");
      
      //print the information out.
      System.out.println(Fr1.toString());
  }
}
  
  