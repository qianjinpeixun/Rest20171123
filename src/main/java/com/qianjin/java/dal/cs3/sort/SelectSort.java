package com.qianjin.java.dal.cs3.sort;

import java.util.Arrays;

public class SelectSort {

    public static int[] selectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min=arr[i];
            int index=i;
            for(int j=i+1;j<arr.length-1;j++){
                if(arr[j]<min){
                    min=arr[j];
                    index=j;
                }
            }
            if(index!=i){
                int temp=arr[index];
                arr[index]=arr[i];
                arr[i]=temp;
            }
        }
        return arr;
    }
  
    public static void main(String[] args) {
        int[] arr = { 6, 2, 4, 1, 5, 9 };
     
        arr=selectSort(arr);
        System.out.println(Arrays.toString(arr));
        
        arr=insertSort(arr);
        System.out.println(Arrays.toString(arr));
        
        
        arr=quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        
    }
    
    public static int[] insertSort(int[] arr){
        for(int i=1;i<arr.length-1;i++){
            int key=arr[i];
            for(int j=i-1;j>0;j--){
                if(arr[j]>key){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }else break;
            }
        }
        return arr;
    }
    
    public static int[] quickSort(int a[], int start, int end) {
        if (start >= 0 && end <= a.length - 1 && start < end) {
            int low = start;
            int high = end;
            int splitKey = a[start];
            while (start < end) {
                while (start < end && a[end] >= splitKey) end--;
                a[start] = a[end];
                while (start < end && a[start] <= splitKey) start++;
                a[end] = a[start];
            }
            a[end] = splitKey;
            quickSort(a, low, start - 1);
            quickSort(a, start + 1, high);
        }
        return a;
    }



}
