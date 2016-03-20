package com.java.base;

public class Unknown {

	private int size = 5;

	public Object makeInner(int localVar) {
		final int finalLocalVar = localVar;
		return new Object() {
			// 使用匿名内部类
			public String toString() {
				return "OuterSize=" + size + "\nfinalLocalVar=" + finalLocalVar;
			}
		};
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object obj=new Unknown().makeInner(47);
		 System.out.println(obj.toString());
	}

}
