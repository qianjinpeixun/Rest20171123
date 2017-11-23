package com.qianjin.java.dal.cs3.java2110.ass1ak;

public class StringMatch {

    public static void main(String[] args) {
        
        String s1="mississippi";
        String s2="s";
        int count=getCount(s1,s2);
        System.out.println(count);
    }
    
    public static int getCount(String s1,String s2){
        int count=0;
        int index=0;
        while(true){
            index=indexof(s1,s2);
            if(index==-1){
                break;
            }
            s1=s1.substring(index+s2.length());
            count++;
        }
        return count;
    }
    
    private static int indexof(String s1,String s2){
        int index=-1;
        for(int i=0;i<s1.length();i++){
            char c1=s1.charAt(i);
            if(c1==s2.charAt(0)){
                int position1=i+1;
                int position2=1;
                boolean isSub=false;
                while(true){
                    if(position1>=s1.length()){
                        isSub=false;
                        break;
                    }
                    if(position2>=s2.length()){
                        isSub=true;
                        break;
                    }
                    if(s1.charAt(position1)!=s2.charAt(position2)){
                        isSub=false;
                        break;
                    }else{
                        position1++;
                        position2++;
                    }
                    
                }
                if(isSub==true){
                    return i;
                }
            }
        }
        
        return index;
    }

}
