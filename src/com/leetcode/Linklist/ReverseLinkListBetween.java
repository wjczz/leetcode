package com.leetcode.Linklist;

public class ReverseLinkListBetween {

	
	 public static ListNode ReverseBetween(ListNode head, int m, int n) {
		 ListNode result = new ListNode(0);
		 result.next = head;
		 ListNode first = result;
		 ListNode pre = null;
		 ListNode cur = null;
		 ListNode next = null;
		 ListNode bottom = null;
		 int i = 0;
		 while(true)
		 {
			 if(i > 0 && i < m)
			 {
				 first = first.next;
				 if(first == null)
				 {
					 break;
				 }
			 }
			 else if(i == m)
			 {
				 pre = first.next;
				 bottom = first.next;
				 cur = pre.next;
				 pre.next = null;
				 if(cur == null)
				 {
					 break;
				 }
				 if(cur.next != null)
				 {
					 next = cur.next;
				 }
			 }
			 else if(i > n)
			 {
				 break;
			 }
			 else if(i > m && i <= n)
			 {
				 first.next = cur;
				 cur.next = pre;
				
				 
				 pre = cur;
				 cur = next;
				 if(cur == null)
				 {
					 if(i == n)
					 {
						 break;
					 }
				 }
				 else
				 {
					 next = next.next;				 					 
				 }
			 }
			
			 
			 i++;
		 }
		 if(cur != null)
		 {
			 bottom.next = cur;
		 }
		 head = result.next;
		 return head;
	 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(2);
		list2.next = list1;
		ListNode list3 = new ListNode(3);
		list3.next = list2;
		ListNode list4 = new ListNode(4);
		list4.next = list3;
		ListNode list5 = new ListNode(5);
		list5.next = list4;
		ListNode list = ReverseBetween(list2,1,2);
		while(list != null)
		{
			System.out.println(list.val);
			list = list.next;
		}
	}

	
}
