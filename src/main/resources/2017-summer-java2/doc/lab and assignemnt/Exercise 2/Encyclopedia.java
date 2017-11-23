/*Lab4, Question 2 CSCI 1101
   Student.java holds information about a student at Dalhousie in CSCI1101 and
   their grades
   June 30, 2017
   Jiaming Han B00726481 
   This is entirely my own work. */
   
public class Encyclopedia extends Book{
  private int numTopics;
  //constructor method. this class has inherited all of common attributes and operations. 
  public Encyclopedia(int p,int t){
      setPages(p);
      numTopics = t;
  }
  // set method (to modify).
  public void setTopics(int n){
    numTopics = n;
  }
  // get method (to access).
  public int getTopics(){
    return numTopics;
  }
  // get average number of topics for each page. 
  public double  computeTopicsPerPage(){
    double avgT = numTopics / getPages() ;
    return avgT;
  }
}