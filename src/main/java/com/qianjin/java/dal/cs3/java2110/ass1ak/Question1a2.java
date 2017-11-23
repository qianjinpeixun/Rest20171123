package com.qianjin.java.dal.cs3.java2110.ass1ak;

import java.util.ArrayList;
import java.util.Stack;

public class Question1a2 {

    private static ArrayList<Stack> list=new ArrayList<>();
    private static Stack<String> stack=new Stack<>();
    
    public static void main(String[] args) {

        
        int count = getCount(2,2);
        System.out.println("count=" + count+",list size="+list.size());
        pirntList();
        
    }
    
    public static void pirntList(){
        String line="[";
        for(Stack<String> stack:list){
            String str="";
            while(!stack.isEmpty()){
                str=str+stack.pop();
            }
            line=line+str+",";
        }
        line=line+"]";
        System.out.println(line);
    }

    public static int getCount(int row, int col) {
        if (row == 0 && col == 0) {
            list.add(stack);
            stack=new Stack<String>();
            return 0;
        } else if (row == 0 || col == 0) {
            if(row==0){
                int kk= getCount(row, col - 1);
                stack.push("E");
                return kk;
            }else{
               int kk= getCount(row-1, col);
                stack.push("N");
                return kk;
            }
            
        } else {
            int rows=getCount(row, col - 1);
            stack.push("E");
            int cols=getCount(row - 1, col);
            stack.push("N");
            return  rows+cols ;
        }
    }
}
