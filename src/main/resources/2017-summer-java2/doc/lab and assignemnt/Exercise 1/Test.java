/*Lab4, Question 1  - demo class CSCI 1101
   StudentDemo.java is a demo program for the Student class. It creates student 
   objects, and compares different students.
   June 30, 2017
   Jiaming Han B00726481
   I received help with creating Student objects from my TA but the rest is my
   own work. */

public class Test {
   public static void main(String[] args){
      Airline  air = new Airline ("AirCanada");
      Plane ac1 = new Plane("AC001", 40);
      Plane ac2 = new Plane("AC002", 50);
      Plane ac3 = new Plane("AC003", 60);
      
   //Create an Airline class with at least 3 Planes to be the object.
      air.addPlane(ac1);
   //Add passengers to all the Planes.
      ac1.addPassengers(20);
      ac2.addPassengers(30);
      ac3.addPassengers(40);
   //Add the planes to your airline.
      air.addPlane(ac2);
      air.addPlane(ac3);
   //Print out the totalNumber of planes that the airline has. 
      System.out.println("the totalNumber of planes :"+ air.getTotalPlanes());
      
   //Print out the total number of passengers on all the planes
      System.out.println("the total number of passengers :"+ air.getTotalPassengers());
    
   //Print out the percentageFull on all the Planes.  
      System.out.println("the percentageFull on all the Planes."+ air.percentageFull());
      
   //Print out the plane object that has the most seats.
      if (ac1.hasMoreSeats(ac2)) {
        if (ac1.hasMoreSeats(ac3))
         System.out.println("plane that names "+ ac1.getPlaneName() + " has the most seats.");
        else 
         System.out.println("plane that names "+ ac3.getPlaneName() + " has the most seats.");
      }
      
      else {
      if (ac2.hasMoreSeats(ac3))
         System.out.println("plane that names "+ ac2.getPlaneName() + " has the most seats.");
      else
          System.out.println("plane that names "+ ac3.getPlaneName() + " has the most seats.");
      } 
   //Call the toString method in the Airline Class.
      System.out.println(air.toString());   
   }
}
