package com.java.base;

import java.lang.reflect.Method;


public class SuperClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		A a = new A();
//		a.show();
//
//		A b = new B();
//		b.show();
		
		B b = new B();
		b.get();
//
//		String s1 = args[1];
//		String s2 = args[2];
//		String s3 = args[3];
//		String s4 = args[4];
//		System.out.println("args[1]=" + s1);
//		System.out.println("args[2]=" + s2);
//		System.out.println("args[3]=" + s3);
//		System.out.println("args[4]=" + s4);

//		 try {  
//	           Class c = Class.forName("java.util.Stack");  
//
//	          Method m[] = c.getDeclaredMethods();  
//	             
//	           for (int i = 0; i < m.length; i++)  
//	               System.out.println(m[i].toString());  
//	      }  
//	      catch (Throwable e){  
//	            System.err.println(e);  
//	      }  
	}

}

class A {
	int a = 3;
	double d = 2.0;

	void show() {
		System.out.println("Class A: a=" + a + "\td=" + d);
	}
	
	void getLength()
	{
		 StringBuffer s;
//		System.out.println(s.length());
	}
}

class B extends A implements FuckService{
//	float a = 3.0f;
	String d = "Java program.";

	void show() {
		super.show();
//		System.out.println("Class B:  a=" + a + "\td=" + d);
	}

	@Override
	public int get() {
		// TODO Auto-generated method stub
		
		return 0;
	}
	
	
}


