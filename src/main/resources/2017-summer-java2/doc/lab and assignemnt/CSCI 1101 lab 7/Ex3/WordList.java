/*Lab7, Question 3 CSCI 1101
   Student.java holds information about a student at Dalhousie in CSCI1101 and
   their grades
   July 17, 2017
   Jiaming Han B00726481 
   This is entirely my own work. */
   
import java.util.ArrayList;  
public abstract class WordList{
  private ArrayList list;
  
     public WordList(){
      list = new <String> ArrayList();
     }
     // shallow copy
     public ArrayList <String> getList(){
       return list;
     }
     // deep copy
     public void setList(ArrayList <String> l){
          list = new ArrayList();
       for(int i=0; i<l.size(); i++)
          list.add(l.get(i));
     }
     public abstract boolean compare(WordList w);
}