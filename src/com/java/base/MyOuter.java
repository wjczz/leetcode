package com.java.base;

//�����ڲ���
public class MyOuter {

	private int x = 100;

	public void outerMethod() {
		x++;
	}

	public void makeInner() {
		// ���ⲿ�෽���д����ڲ���ʵ��
		MyInner in = new MyInner();
	}

	
	 private class MyInner implements testInterface{
		private String str = "Hello";

		public void innerMethod() {
			System.out.println("�ڲ����� String =" + str);
			System.out.println("�ⲿ���е�x =" + x);// ֱ�ӷ����ⲿ���е�ʵ������x
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
		// ʹ���ⲿ�๹�췽������mo����
		MyOuter.MyInner inner = outer.new MyInner();// �����ڲ�����Ҫͨ���ⲿ���ʵ�����ܴ���������ʵ��������Ҫͨ����������������
		// ����inner����
		inner.innerMethod();
	}
}
interface testInterface
{
	}
