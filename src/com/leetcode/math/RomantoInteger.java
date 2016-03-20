package com.leetcode.math;

public class RomantoInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println(romanToInt("MMCMXCIX"));
	}

	public static int romanToInt(String s) {
		int pre = CharToInt(s.charAt(0));
		int result = 0;
        for(int i = 1; i < s.length(); i++)
        {
        	int cur = CharToInt(s.charAt(i));
        	if(cur <= pre)
        	{
        		result += pre;
        	}
        	else
        	{
        		result -= pre;
        	}
        	pre = cur;
        }
        result += CharToInt(s.charAt(s.length()-1));
		return result;
    }
	
	public static int CharToInt(char a)
	{
		int result = 0;
		switch (a)
		{
		case 'I':
			result = 1;
			break;
		case 'V':
			result = 5;
			break;
		case 'X':	
			result = 10;
			break;
		case 'L':
			result = 50;
			break;
		case 'C':
			result = 100;
			break;
		case 'D':
			result = 500;
			break;
		case 'M':
			result = 1000;
			break;
		}
		return result;
	}
}
