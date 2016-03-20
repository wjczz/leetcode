package com.leetcode.Linklist;



public class ListNode {
    int val;
    ListNode next;
   
    ListNode(int x) {
       val = x;
       next = null;
   }
    
    int getValue(){
    	return val;
    }
    
    ListNode (int[] a)
    {
    	this.val = a[0];
    	ListNode node = new ListNode(a[0]);
    	ListNode cur = node;
    	for(int i = 1; i < a.length; i++)
    	{
    		ListNode ln = new ListNode(a[i]);
    		cur.next = ln;
    		cur = cur.next;
    	}
    	this.next = node.next;
    }
    
    public ListNode getCycle(ListNode a)
    {
    	ListNode cur = a;
    	ListNode test = cur.next;
    	while(cur != null)
    	{
    		if(cur.next == null)
    		{
    			cur.next = test;
    			break;
    		}
    		cur = cur.next;
    	}
    	return a;
    }
}
