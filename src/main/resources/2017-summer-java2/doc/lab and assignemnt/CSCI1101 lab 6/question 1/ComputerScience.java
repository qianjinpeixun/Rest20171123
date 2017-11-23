/*Lab6, Question 1 CSCI 1101
   Student.java holds information about a student at Dalhousie in CSCI1101 and
   their grades
   July 10, 2017
   Jiaming Han B00726481
   This is entirely my own work. */
  
public class ComputerScience extends Course{
  private int numGrade;
  private double[] grade;
  private int n = 0;
  
    //constroctor
    public ComputerScience (int num){
      numGrade = num;
      grade = new double[num];
    }
    
    public double[] getGrades(){
      return grade;
    }
    // add the grade up to the grade arrays.
    public void addGrade(double grades){
 
      grade[n]=grades;
      if(n<numGrade)
         n++;
    }
    
    //override method
    public void calculateFinalGrade() {
      double sumGrade =0;
      for(int i=0;i<grade.length;i++){
         sumGrade = sumGrade + grade[i];
         System.out.println(grade[i]);
      }
      super.setFinalGrade(sumGrade / numGrade); 
    }
    // find the maximum number of the grade.    
    public double findMax(){
      double a = 0;
      for(int i =0;i<grade.length;i++)
         a = Math.max(a,grade[i]);
      return a;     
    }
    
    public String toString(){
      String ts = super.toString();
      ts +=  "\nthe maximum number in our class is : " + findMax() + ", and The average of final grade of ComputerScience is: " + getFinalGrade() ;
      return ts;
    }
}