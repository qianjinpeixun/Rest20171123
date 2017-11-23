/*Lab4, Question 2  - demo class CSCI 1101
   StudentDemo.java is a demo program for the Student class. It creates student 
   objects, and compares different students.
   June 30, 2017
   Jiaming Han B00726481
   I received help with creating Student objects from my TA but the rest is my
   own work. */

public class Test2 {
 public static void main(String[] args){
 // creating two testing value for the two variable of each object
  Encyclopedia eBook1 = new Encyclopedia(14451,12138);
  Encyclopedia eBook2 = new Encyclopedia(15123,10122);
   //modify the information for two difference instance
   eBook1.setPages(123);
   eBook1.setTopics(1230);
   
   eBook2.setPages(456);
   eBook2.setTopics(4560);
   
   System.out.println(eBook1.computeTopicsPerPage()); 
   System.out.println(eBook2.computeTopicsPerPage());  
   }
}