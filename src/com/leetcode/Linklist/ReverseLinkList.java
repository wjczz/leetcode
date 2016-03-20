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
	        //�߽紦��
	        //�սڵ�
	        if(pre == null) return null;
	        //ֻ��1���ڵ�
	        if(pre.next == null){
	            return pre;
	        }
	        else {
	            cur = pre.next;
	        }
	        //ֻ��2���ڵ�
	        if(cur.next == null){
	        	pre.next = null;
	            cur.next = pre;
	            return cur;
	        }
	        //����2���ڵ�
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
	            //ͷָ����βָ�룬����ָ��Null
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
