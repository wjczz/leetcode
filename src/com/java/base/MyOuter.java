package com.java.base;

//常规内部类
public class MyOuter {

	private int x = 100;

	public void outerMethod() {
		x++;
	}

	public void makeInner() {
		// 在外部类方法中创建内部类实例
		MyInner in = new MyInner();
	}

	
	 private class MyInner implements testInterface{
		private String str = "Hello";

		public void innerMethod() {
			System.out.println("内部类中 String =" + str);
			System.out.println("外部类中的x =" + x);// 直接访问外部类中的实例变量x
			outerMethod();
			System.out.println("x =" + MyOuter.this.x);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyOuter outer = new MyOuter();
		// 使用外部类构造方法创建mo对象
		MyOuter.MyInner inner = outer.new MyInner();// 常规内部类需要通过外部类的实例才能创建对象，与实例变量需要通过对象来访问相似
		// 创建inner对象
		inner.innerMethod();
	}
}
interface testInterface
{
	}
