package com.leetcode.Linklist;

public class ReverseLinkList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(2);
		list2.next = list1;
		ListNode list = new ListNode(3);
		list.next = list2;
	//	ReverseList(list);
		ListNode result;
		result = RemoveNthFromEnd(list,2);
	}
	
	 public static ListNode ReverseList(ListNode head) {
		    ListNode pre = head;
	        ListNode cur = null;
	        ListNode next = null;
	        //边界处理
	        //空节点
	        if(pre == null) return null;
	        //只有1个节点
	        if(pre.next == null){
	            return pre;
	        }
	        else {
	            cur = pre.next;
	        }
	        //只有2个节点
	        if(cur.next == null){
	        	pre.next = null;
	            cur.next = pre;
	            return cur;
	        }
	        //至少2个节点
	        next = cur.next;
	        head.next = null;
	        while(true){
	        	cur.next = pre;
	        	if(next != null){
	        		pre = cur;
	        		cur = next;
	        		next = next.next;
	        	}
	        	else{
	        		return cur;
	        	}
	        }
	 }

	 public static ListNode RemoveNthFromEnd(ListNode head, int n) {
	        ListNode list = ReverseListNode(head);
	        ListNode pre = list;
	        ListNode cur = list.next;
	        if(cur == null && n == 1)
	        {
	            return null;
	        }
	        else if(n == 1)
	        {
	             list = list.next;
	              return ReverseListNode(list);
	        }
	        
	        int index = 2;
	        while(cur != null){
	            if(index == n){
	                pre.next = cur.next;
	                break;
	            }
	            pre = cur;
	            cur = cur.next;
	            index++;
	        }
	        return ReverseListNode(list);
	    }
	    
	 public static ListNode ReverseListNode(ListNode head){
	        ListNode pre = head;
	        ListNode cur = head.next;
	        ListNode next = null;
	        if(cur == null){
	                return head;
	        }
	        else{
	            next = cur.next;
	            //头指针变成尾指针，必须指向Null
	            pre.next = null;
	        }
	        while(true)
	        {
	            cur.next = pre;
	            if(next != null){
	                pre = cur;
	                cur = next;
	                next = next.next;
	            }
	            else
	            {
	                return cur;
	            }
	        }
	        
	    }
}
