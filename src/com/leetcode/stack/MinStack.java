package com.leetcode.stack;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> stackData = new Stack<Integer>();
	private Stack<Integer> stackMin = new Stack<Integer>();

	public void push(int x) {
		stackData.push(x);
		if(stackMin.isEmpty() || x <= stackMin.peek())
		{
			stackMin.push(x);
		}
	}

	public void pop() {
		if(stackData.isEmpty())
		{
			return;
		}
		int x = stackData.peek();
		stackData.pop();
		System.out.println("pop:"+ x);

		if(x <= stackMin.peek())
		{
			stackMin.pop();
		}
	}

	public int top() {
		System.out.println("Top:"+ stackData.peek());

		return stackData.peek();
	}

	public int getMin() {
		if(stackMin.isEmpty())
		{
			throw new RuntimeException("Your stack is emoty");
		}
		System.out.println("Min:"+ stackMin.peek());
		return stackMin.peek();
		
	}

	/* ����:ʵ��һ����ȡ��СԪ�ص�ջ,Ҫ��ÿһ�������ĸ��Ӷȶ�������O(1)
	 * ˼·:һ��ʼֻ���밴��ԭ����һ��ջȥʵ�֣�����ʵ�ֲ���,
	 * ��Ϊ����ȡ��СԪ�ص�ʱ��ʱ�临�Ӷ�ΪO(n).��ʱ���ֻ�ܿռ任ʱ���� 
	 * ˼·����һ��ջר�ż�¼��С��ֵ
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack mstack = new MinStack();
		for(int i = 0; i < 10; i++)
		{
			int x = (int)(Math.random() * 10);
			mstack.push(x);
			System.out.print(x+ " ");
		}
		mstack.getMin();
		mstack.top();
		mstack.pop();
		mstack.getMin();

	}

}
