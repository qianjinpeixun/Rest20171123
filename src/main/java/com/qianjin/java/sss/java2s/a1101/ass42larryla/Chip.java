package com.qianjin.java.sss.java2s.a1101.ass42larryla;


public class Chip{
   private String colour;
   
   public Chip(String c){//constructor
      this.colour=c;
   }
   public String getChip(){//get and set chip
      return colour;
   }
   public void setChip(String a){
      this. colour=a;
   }
   
   public boolean equals(Chip c){
      if(c.getChip()==this.colour){
         return true;
      }else{
         return false;
      }
   }
   public String toString(){//toString method return the chip
      String a="";
      a+=getChip();
      return a;
   }
}