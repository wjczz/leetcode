package com.leetcode;
/**
 * @(#)DataSwap.java
 *
 *
 * @author 
 * @version 1.00 2014/6/28
 */


public class DataSwap {

    public DataSwap() {
    	
    }
      
    public static void swap(int x ,int y){
    	int temp = x;
    	x = y;
    	y = temp;
    	}
  
    public static void swap(int[]change,int index1,int index2){
    	int temp = change[index1];
    	change[index1] = change[index2];
    	change[index2] = temp;
    }
    
    public static void main (String[] args) {
    	int a = 1;
    	int b = 2;
    	int[] change = new int[2];
    	change[0] = a;
    	change[1] = b;
    	System.out.println("交换前 a ="+a+" b ="+b);
    	swap(change,0,1);
    	a = change[0];
    	b = change[1];
//    	swap(a,b);
    	System.out.println("交换后 a ="+a+" b ="+b);
    }
}