package com.leetcode.Linklist;

public class PalindromeList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(1);
		ListNode list3 = new ListNode(2);
		ListNode list4 = new ListNode(1);
		//ListNode list5 = new ListNode(1);
		list1.next = list2;
		list2.next = list3;
		list3.next = list4;
	//	list4.next = list5;
		System.out.print(IsPalindrome(list1));
	}
	
	 public static boolean IsPalindrome(ListNode head) {
		  ListNode copyhead = null;
		  ListNode cur1 = head; 
		  ListNode cur2 = null;
		  int num = 0;
		  while(cur1 != null){
			  if(copyhead == null){			  
				  copyhead = new ListNode(cur1.val);
				  cur2 = copyhead;
			  }
			  else {
				  copyhead.next = new ListNode(cur1.val);
				  copyhead = copyhead.next;
			  }
			  cur1 = cur1.next;
			  num ++;
		  }
	        ListNode reverse_head = ReverseList(cur2);
	        cur1 = head;
	        cur2 = reverse_head;
	        boolean result = true;
	        while(true){
	            if(cur1 == null || cur2 == null)
	            {
	                break;
	            }
	            if(cur1.val == cur2.val)
	            {
	                cur1 = cur1.next;
	                cur2 = cur2.next;
	            }
	            else {
	                result = false;
	                break;
	            }
	        }
	        return result;
	    }
	    
	 public static ListNode ReverseList(ListNode head){
	        ListNode pre = head;
	        ListNode cur = head.next;
	        ListNode next = null;
	        if(cur == null){
	            return head;
	        }
	        else {
	            next = cur.next;
	            pre.next = null;
	        }
	        while(true){
	            cur.next = pre;
	            if(next != null){
	                pre = cur;
	                cur = next;
	                next = next.next;
	            }
	            else {
	                return cur;
	            }
	        }
	    }
	

}
