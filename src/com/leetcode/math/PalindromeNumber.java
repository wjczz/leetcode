package com.leetcode.math;

public class PalindromeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(0));
	}

	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		else if(x == 0)
		{
			return true;
		}
		String s = "";
		while (x > 0) {
			int i = x % 10;
			s = s + i;
			x = x / 10;
		}
		for(int i = 0, j = s.length() - 1; i < s.length() && j >= 0; i++,j--)
		{
			
			if(s.charAt(i) == s.charAt(j))
			{
				if(i >= j)
				{
					return true;
				}
				else
				continue;
			}
			else
			{
				return false;
			}
		}
		return false;
	}
}
