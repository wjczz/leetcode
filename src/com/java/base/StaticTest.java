package com.java.base;

public class StaticTest {

	static Test test2 =  new Test();
	private Test test = new Test(10);
	static
	{
		System.out.println("static �����");
	}
	{
		System.out.println("��ͨ �����");
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
		System.out.println("static ������ construct");
	}
	Test(int b)
	{
		System.out.println("��ͨ������ construct");
	}
}