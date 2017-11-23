/*Lab18, Question 1  - demo class CSCI 1101
   StudentDemo.java is a demo program for the Student class. It creates student 
   objects, and compares different students.
   July 21, 2017
   Jiaming Han B00726481 
   I received help with creating Student objects from my TA but the rest is my
   own work. */
   

public class Demo {
   public static void main(String[] args){
     
     String str1 = "My";
     String str2 = "Heart";
     String str3 = "will";
     String str4 = "go";
     String str5 = "on";
     
     //creat a linklist, and n1 is being the front of the list.
     Node n7 = new Node(str2,null);
     Node n6 = new Node(str1,n7);
     Node n5 = new Node(str5,n6);
     Node n4 = new Node(str4,n5);
     Node n3 = new Node(str3,n4);
     Node n2 = new Node(str2,n3);
     Node n1 = new Node(str1,n2);      
     LinkedList linkL = new LinkedList(n1);
   
    //test
     System.out.println(linkL);
     System.out.println(linkL.size());
     System.out.println(linkL.getFrontNode());
     System.out.println(linkL.getFrontData());       
     System.out.println(linkL.countWord("Heart"));
     System.out.println(linkL.lastIndexOf("My"));
     linkL.remove("Heart");
     linkL.remove(4);
     linkL.removeFront();
     linkL.add(2,"will");
     System.out.println(linkL);
     linkL.clear();
     System.out.println(linkL.isEmpty()); 
     }
}