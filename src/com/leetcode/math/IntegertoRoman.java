package com.leetcode.math;

public class IntegertoRoman {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(5));
	}

	 public static String intToRoman(int num) {
	     String result = "";
	     int bit = 1000;
	     while(num > 0)
	     {
	    	 int i = num / bit;
	    	 if(i > 0)
	    	 {
	    		 result += Roman(i, bit);
	    	 }
	    	 num = num % bit;
	    	 bit /= 10;
	     }
		 return result;
	 }
	 
	 public static String Roman(int roman, int bit)
	 {
		 String result = "";
		 //1000
		 //500
		 //100
		 //50
		 //10
		 //5
		 //1
		switch (bit) {
		case 1000:
			for(int i = 0; i < roman; i++)
			{
				result += "M";
			}
			break;
		case 100:
			result = returnStr(roman, "C", "D", "M");
			break;
		case 10:
			result = returnStr(roman, "X", "L", "C");
			break;
		case 1:
			result = returnStr(roman, "I", "V", "X");
			break;
		}
		 return result;
	 }
	 
	 public static String returnStr(int num, String one, String five, String ten) 
	 {
		 String result = "";
		 switch(num)
			{
			case 0:
			case 1:
			case 2:
			case 3:
				for(int i = 0; i < num; i++)
				{
				 result += one;
				}
				break;
			case 4:
				result = one + five;
				break;
			case 5:
				result = five;
				break;
			case 6:
			case 7:
			case 8:
				result = five;
				for(int i = 0, imax = num%5 ; i < imax; i++)
				{
					result += one;
				}
				break;
			case 9:
				result = one + ten;
				break;
			}
		 return result;
	 }
}
