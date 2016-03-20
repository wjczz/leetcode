package com.java.base;

public class UserStatic {

	public SonStatic  s = new SonStatic();
	UserStatic()
	{
		System.out.println("user static");
	}
	static int a = 1;
	int b = 2;
	public static void setValue()
	{
		System.out.println("user a++");
		
	}
	static{
		a++;
		System.out.println("static ´úÂë¿é");
	}
	{
		System.out.println("this is user static");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SonStatic son =  new SonStatic();
		UserStatic user = new UserStatic();
	}


	
}
 class SonStatic
{
	SonStatic()
	{
		System.out.println("son static");
	}
	static
	{
		System.out.println("this is son static");
	}

}
