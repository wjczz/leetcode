package com.leetcode.string;

import java.util.ArrayList;

import com.sun.xml.internal.ws.util.StringUtils;

public class ZigZagConversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("PAYPALISHIRING",3));
	}

	public static String convert(String s, int numRows) {
		if(s.equals("") || numRows <= 1)
		{
			return s;
		}
		String[] strArray  = new String[numRows];
		for(int i = 0; i< numRows; i++)
		{
			strArray[i] = "";
		}
		int index = 0;
		boolean flag = true; //true: 奇数列, false: 偶数列
		
		while(index < s.length())
		{
			if(flag)
			{
				for(int i = 0; i < numRows && index < s.length(); i++)
				{
					char str = s.charAt(index);
					strArray[i] = strArray[i] + str;
					index++;
				}
				flag = false;
			}
			else
			{
				for(int j = numRows - 2; j > 0 && index < s.length(); j--)
				{
					char str = s.charAt(index);
					strArray[j] = strArray[j] + str;
					index++;
				}
				flag = true;
			}
		}
		String str = "";
		for(int i = 0; i< numRows; i++)
		{
			str	+= strArray[i];
		}
		return str;
	}
}
