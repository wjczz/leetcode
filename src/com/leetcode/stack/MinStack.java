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

	/* 需求:实现一个获取最小元素的栈,要求每一个函数的复杂度都必须是O(1)
	 * 思路:一开始只是想按照原来用一个栈去实现，可是实现不了,
	 * 因为当获取最小元素的时候，时间复杂度为O(n).这时候就只能空间换时间了 
	 * 思路：用一个栈专门记录最小的值
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
