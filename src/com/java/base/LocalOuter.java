package com.java.base;

public class LocalOuter {

	private int size = 5;
	private int y = 7;
	private static int x = 100;
	public Object makeInner(int localVar) {
		final int finalLocalVar = localVar;
		// �����ڲ��࣬����ֻ��makeInner����������Ч������ֲ�����һ�����ڷ������ⲿ���ܴ���MyInner��Ķ���
		class MyInner {
			int y = 4;

			public String toString() {
				System.out.println(x);
				return "OuterSize:" + size + "\nfinalLocalVar:" + finalLocalVar + " "
						+ "\nthis.y=" + this.y;

			}
		}
		return new MyInner();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalOuter lo = new LocalOuter();
		// ����LocalOuter����obj������������makeInner�����������÷�������һ��
		Object obj = lo.makeInner(47);
		// �÷�������һ��MyInner���͵ĵĶ���obj��Ȼ�������ͬtoString������
		System.out.println(obj.toString());
	}

}
