/*Lab7, Question 3 CSCI 1101
   Student.java holds information about a student at Dalhousie in CSCI1101 and
   their grades
   July 17, 2017
   Jiaming Han B00726481 
   This is entirely my own work. */
   
import java.util.ArrayList;  
public class AlphabetizedList extends WordList {

  public AlphabetizedList() {
      super();
  }
  
  public AlphabetizedList(ArrayList <String> l) {
      super.setList(l);
  }    
  //compare the first words of two arraylist. 
  public boolean compare(WordList w){
      int answer = getList().get(0).compareTo(w.getList().get(0));
     if(answer<0){
      System.out.println(getList().get(0) + " comes before "+ w.getList().get(0));
      return true;
     }
     else if(answer>0){
      System.out.println(getList().get(0) + " comes after"+ w.getList().get(0));
      return false;
     }
     else
      System.out.println(getList().get(0) + " is totally same as "+ w.getList().get(0));
    return false;   
  }
 // ordering each elements that in list.
 public void AlphabetizedList(){
      ArrayList arrL = getList();
    for(int i=0; i<arrL.size();i++){
      for(int j=0; j<(arrL.size()-1);j++){
        if(arrL.get(j).toString().compareTo(arrL.get(j+1).toString())>0){
           String a = arrL.get(j).toString();
           String b = arrL.get(j+1).toString();
           arrL.set(j,b);
           arrL.set(j+1,a);
        }
      }
    }
  }
  
  //combine with each list.
  public void merge(AlphabetizedList al){
    ArrayList <String> arrL = al.getList();
    for(int i=0; i<arrL.size(); i++)
      getList().add(arrL.get(i));
  }
  
  public String toString(){
   String ts = "";
      ts += "Alphabetizedlist is : " + getList();
   return ts;
  }
}