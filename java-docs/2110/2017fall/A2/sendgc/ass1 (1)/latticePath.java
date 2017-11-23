package assignment1;


/*Assignment 1 Question 2 CSCI 2110
 * 10.3 latticePath.java
 * Yiping Liang B00744822
 *  I asked some help from learning center and TA */
import java.util.*;

public class latticePath {
	public static void main(String[] args)
	{
		//N = 1, E=0;
		//set starting and ending time 
		long st, ex, et;
				ArrayList<String> result = new ArrayList<String>();// store all possible routine
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the lattice size: ");
		int n = scan.nextInt();
		st = System.currentTimeMillis();
		//given the input size of lattice, if we set go north is 1  go east is 0 
		//111000(NNNEEE) is the largest value for 3*3 lattice
		//000111(EEENNN) is the smallest value of possible move.
		int bot = ((int)Math.pow(2,n))-1;
		int top = ((int)Math.pow(2,(n*2)))-1;
		int loc = 0;//location
		//start from the largest until the smallest
		for(int i=top;i>=bot;i--)
		{
			String r="";
			int nn=0, ee=0;
			//convert decimal to binary
			String temp = Integer.toBinaryString(i);
			int x = 2*n-temp.length();
			//given binary 000111 can only be recognized as 111 by computer which leading 0s will not be shown
			//therefore, check the length of the binary number, if length less than 2n which means leading 0s missing
			//just store missing leading 0 into string first
			if(x>0)
			{
				ee+=x;
				for(int m=0;m<x;m++)
				{
					r+="E";
				}
			}
			
			//add N if current charactor is 1, E otherwise
			for(int j=0;j<temp.length();j++)
			{
				if(temp.charAt(j)=='1')
				{
					nn++;
					r=r+"N";
				}else
				{
					ee++;
					r=r+"E";
				}
			}
			//check the number of N and E, if they are equal and equal to input size n
			//then it is a valid routine, store it into arraylist
			if(nn==ee&&nn==n)
			{
				
				result.add(loc,r);
				loc++;
				
			}
		}
		//problem2
		//check current arraylist, NE or EN can be replace by D
		int xx=result.size();
		for(int z=0;z<xx;z++)
		{
			String tt="";
			//check strings in array list charactor by charactor
			for(int y=1;y<result.get(z).length();y++)
			{
				//add D to new String if exist EN or NE
				if(result.get(z).charAt(y)!=result.get(z).charAt(y-1))
				{
					tt=tt+"D";
					y++;
				}else//otherwise just store current charactor into string
				{
					tt=tt+result.get(z).charAt(y);
				}
			}
			//check the number of N and E in current string, if they are not equal add N or E to the end of String
			int nn=0, ee=0;
			for(int s=0;s<tt.length();s++)
			{
				if(tt.charAt(s)=='N')
				{
					nn++;
				}else if(tt.charAt(s)=='E')
				{
					ee++;
				}
			}
			if(nn>ee)
			{
				tt=tt+"E";
			}else if(ee>nn)
			{
				tt=tt+"N";
			}
			//if result has already been stored into arraylist, ignore, otherwise, store it into arraylist
			if(!result.contains(tt)&&tt.length()>0)
			{
				result.add(loc,tt);
				loc++;
			}
		}
		et = System.currentTimeMillis();
		//print out arraylist
		System.out.print("[");
		for(int l=0;l<result.size();l++)
		{
			if(l==result.size()-1)
			{
				System.out.print(result.get(l));
			}else {
			System.out.print(result.get(l)+",");
			}
		}
		System.out.println("]");
		ex = et-st;
		System.out.println("Execution time: "+ ex + "ms");
	}
}
