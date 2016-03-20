package com.java.base;

public class BitOperate {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		short num = 32;
		getBinary(num);
		num = (short) (num >> 32);
		System.out.println(num);
		getBinary(num);
	}
	
	public static void getBinary(int num)
	{
		System.out.println(Integer.toBinaryString(num));
	}
	public static void getBinary(long num)
	{
		System.out.println(Long.toBinaryString(num));
	}
}
