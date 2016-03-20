package com.leetcode.stack;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> stack;
	MinStack(Stack<Integer> stack) {
		// TODO Auto-generated constructor stub
		this.stack = stack;
	}
	public MinStack() {
		// TODO Auto-generated constructor stub
	}
	public void push(int x) {
		if(stack != null)
		{
			stack.push(x);			
		}
    }

    public void pop() {
    	if(stack != null)
		{
    		stack.pop();			
		}
    	
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
    	int result = Integer.MAX_VALUE; 
    	for(int i:stack)
    	 {
    		 if(result > i)
    		 {
    			 result = i;
    		 }
    	 }
    	return result;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		
		MinStack mstack = new MinStack(stack);
		for(int i = 0; i < 1; i++)
		{
			int element = (int)(Math.random() * -10);
			mstack.push(element);
			System.out.print(element + "  ");
		}
		System.out.println();
		System.out.println("first element:" + mstack.top());
		System.out.println("min element:" + mstack.getMin());
		mstack.pop();
		System.out.println("min element:" + mstack.getMin());
		
	}

}
