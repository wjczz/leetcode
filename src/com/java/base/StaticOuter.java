package com.java.base;

//静态内部类
public class StaticOuter {

	private static int x = 100;
	public int test = 1;
	public abstract static class StaticInner implements testInterface
	{
		private String y = "Hello!";

		public void innerMethod() {
			System.out.println("x=" + x);
			System.out.println("y=" + y);
		}
		
		abstract void getx();
	}
	
	public void addMethod()
	{
		x++;
	}
	
	public static void getX()
	{
		System.out.println(x);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//静态内部类可以不需要实例就直接访问
		StaticOuter outer = new StaticOuter();
		outer.getX();
		outer.addMethod();
		StaticOuter.getX();
		StaticOuter.StaticInner inner = new StaticOuter.StaticInner()
		{
			void getx()
			{
				System.out.println(x);
				System.out.println("静态内部类 重写抽象方法");
			}
		};
		
		inner.innerMethod();
		inner.getx();
	}

}
