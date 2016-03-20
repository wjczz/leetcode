package com.leetcode.stack;


import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {

	private LinkedList<Integer> queue;
	
	
	public ImplementStackusingQueues(LinkedList<Integer> queue) {
		this.queue = queue;
	}
	class MyStack {
	    // Push element x onto stack.
	    public void push(int x) {
	    	queue.addFirst(x);
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	        queue.removeLast();
	    }

	    // Get the top element.
	    public int top() {
	        return queue.peek();
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	    	return queue.isEmpty();   
	    }
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
