package com.java.base;
/**
 * ����
 */
class Insurrance{
	void saleIns(int age){
		assert(age>=0 && age<70):"����С��0���ߴ���70�겻�ܹ������ٱ���";
		System.out.println ("������");
	}
	
}

public class AssertDemo {
	public static void main (String[] args) {
    	Insurrance is=new Insurrance();
    	is.saleIns(5);
    }
}