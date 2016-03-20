package com.leetcode.math;

public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(1534236469));
	}

	public static int reverse(int x) {
		int flag = 1;
		if(x < 0)
		{
			flag = -1;
			x = -x;
		}
		int result = 0;
		int bit = 10;
		String s = "";
		int overflow = 0;
		while(x > 0)
		{
			overflow  = x % bit;
			s += overflow;
			x = x / bit;
		}
		bit = 1;
		for(int i = s.length() - 1; i >= 0; i--)
		{
			result = result + Integer.parseInt(s.charAt(i)+"")*bit;
			bit *= 10;
			if(result % 10 != overflow)
			{
				return 0;
			}
		}
		return result*flag;
    }
}
