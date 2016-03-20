package com.leetcode.Linklist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeList {

	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	       ListNode result = null;
	       ListNode  current = null;
	       int i = 0;
	       ListNode l = null;
	       while(l1 != null && l2 != null){
	           int sum = l1.val +l2.val + i;
	           i = sum / 10;
	           l = new ListNode(sum % 10);
	           
	           if(result == null){
	        	   result = l;
	        	   current = l;
	           }
	           else {
	      
	        	   result.next = l;
	        	   result = l;
	           }     
	           l1 = l1.next;
	           l2 = l2.next;           
	       }
	        while(l1 != null){
	    		  int sum = l1.val + i;
		           i = sum / 10;
		           l = new ListNode(sum % 10);
		           result.next = l;
	        	   result = l;
		    	   l1 = l1.next;
	    	   }
	    	  while(l2 != null){
	    		  int sum = l2.val + i;
		           i = sum / 10;
		           l = new ListNode(sum % 10);
		           result.next = l;
	        	   result = l; 
		    	   l2 = l2.next;
	    	  }  
          if(i > 0){
	    	   l = new ListNode(i);
	    	   result.next = l;
	       }
	       return current;
	    }
	
	public static ListNode MergeLists(List<ListNode> lists){
		if(lists.isEmpty()){
			return null;
		}
		ListNode result = lists.get(0);
		for(int i = 1;i < lists.size() ;i++){
		  result = MergeListNode(result,lists.get(i));
		}
		return result;
	}
	
	public static ListNode MergeListNode(ListNode x,ListNode y){
		if(x == null){
			return y;
		}
		else if(y == null){
			return x;
		}
		ListNode a = x;
		ListNode b = y;
		ListNode c = new ListNode(0);
		ListNode result = c;
		while(a != null && b != null){
			if(a.val >= b.val){
				c.next = b;
				c = b;
				b = b.next;	
			}
			else {
				c.next = a;
				c = a;
				a = a.next;	
			}
		}
		c.next = (a !=null) ? a : b;
		return result.next;
	}
	
	public static ListNode mergelist(List<ListNode> lists){
		
		Comparator<Integer> order = new Comparator<Integer>(){
			@Override
			public int compare(Integer a,Integer b){
				return (int)(b-a);//½µÐò
			}

		};
		 if(lists.isEmpty()){
				return null;
			}
			PriorityQueue<Integer> q = new PriorityQueue<Integer>(11,order);
			// PriorityQueue<Integer> q = new PriorityQueue<>();
			for(int i = 0;i < lists.size();i++){
			    ListNode node = lists.get(i);
				while(node != null){
					q.add(node.val);
					node = node.next;
				}
			}
			ListNode result = null;
			if(!q.isEmpty()){
				result = new ListNode(q.poll());
				ListNode l = result;
				while(!q.isEmpty()){
					int v = q.poll();
					l.next = new ListNode(v);
					//q.remove();
					l = l.next;
				}
			}
			return result;
	}
	/**
	 * @param args
	 */

 	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ListNode l = new ListNode(7);
        l.next =  new ListNode(60);
        ListNode l2 = new ListNode(49);
        ListNode l3 = new ListNode(60);
        ListNode l4 = new ListNode(12);
        ListNode l5 = new ListNode(55);
        
        List<ListNode> list = new ArrayList();
        list.add(l);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);
     //   l.next = l3;
     //   l2.next = l4 ;
     //   l4.next = l5;
        //ListNode result = addTwoNumbers(l,l2);
        ListNode result = mergelist(list);
        while(result != null){
        	System.out.println(result.val);
        	result = result.next;
        }    
	}

}
