package com.java.base;

public class StaticTest {

	static Test test2 =  new Test();
	private Test test = new Test(10);
	static
	{
		System.out.println("static 代码块");
	}
	{
		System.out.println("普通 代码块");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(test2.toString());
//		StaticTest st = new StaticTest();
	}

}

class Test
{
	static int a = 0;
	Test()
	{
		System.out.println("static 变量的 construct");
	}
	Test(int b)
	{
		System.out.println("普通变量的 construct");
	}
}