/*Lab8, Question 1 CSCI 1101
   Student.java holds information about a student at Dalhousie in CSCI1101 and
   their grades
   June 23, 2017
   LonghaoLiu B00743382 
   This is entirely my own work.*/
public class LinkedList
{
   private Node front;
   private int count;
  
   //constructor  
   public LinkedList()
   {
       front = null;
       count = 0;
   }

   public void addToFront(String d)
   {
       Node n;
       n = new Node(d, front);
       front = n;
       count++;
   }
  
   //get the size of the list
   public int size()
   {
       return count;
   }

   public boolean isEmpty()//use this method to check is empty or not
   {
       if (front==null)
           return true;
       else
           return false;
   }

   public void clear()
   {
       front = null;
       count=0;//clear
   }
  
   public String getFrontData()
   {
       if (front==null)
           return "Empty list";
       else
           return front.getData();
   }
  
   //new method added - get the first node
   public Node getFront()
   {
       return front;
   }
  
   public void enumerate()
   {
       Node curr = front;
       while (curr!=null)
       {
           System.out.print(curr);
           curr = curr.getNext();
       }
       System.out.println(".");
   }
  
   //remove the front node
   public void removeFront()
   {
       if (front==null)//if else
       {
           System.out.println("Empty list");
       }
       else
       {
           front = front.getNext();
           count--;
       }
   }
  
   public void addToEnd(String d)//this method add the node to the end
   {
       Node n = new Node(d, null);
       Node curr = front;
       if (front==null)
           front = n;
       else
       {
           while (curr.getNext()!=null)
               curr = curr.getNext();
           curr.setNext(n);
       }
       count++;      
   }
   }