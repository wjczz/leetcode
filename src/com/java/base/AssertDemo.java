package com.java.base;
/**
 * 断言
 */
class Insurrance{
	void saleIns(int age){
		assert(age>=0 && age<70):"年龄小于0或者大于70岁不能购买人寿保险";
		System.out.println ("购买保险");
	}
	
}

public class AssertDemo {
	public static void main (String[] args) {
    	Insurrance is=new Insurrance();
    	is.saleIns(5);
    }
}