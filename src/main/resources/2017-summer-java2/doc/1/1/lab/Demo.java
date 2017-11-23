import java.util.ArrayList;
public class Demo
{
   public static void main(String[] args)
   {
      LinkedList list1 = new LinkedList();
      LinkedList list2 = new LinkedList();//create two linkedList      
      list1.addToEnd("A");
      list1.addToEnd("B");
      list1.addToEnd("C");
      list1.addToEnd("D");
      list2.addToEnd("B");
      list2.addToEnd("D");
      list2.addToEnd("E");
      list2.addToEnd("F");
      System.out.println("exercise 3");
      list1.enumerate();
      list2.enumerate();
      LinkedList list3 = new LinkedList();//creates another LinkedList
      list3 = mergeRemove(list1, list2, "C");
      list3.enumerate();//prints contents of list3
      System.out.println("exercise 2");
      list3.enumerate();
      ArrayList<String> a = new ArrayList<String>(list3.size());//makes empty
      a = convert(list3);
      System.out.println(a);
      System.out.println("exercise 3");
      list3.clear();
      list3.addToEnd("A");
      list3.addToEnd("B");
      list3.addToEnd("D");
      list3.addToEnd("E");
      insertAlpha(list3, "C");
      list3.enumerate();
   }

   public static LinkedList mergeRemove(LinkedList list1, LinkedList list2, String word){
      LinkedList list3 = new LinkedList();//makes new LinkedList
      Node 
         