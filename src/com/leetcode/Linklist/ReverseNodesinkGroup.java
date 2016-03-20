package com.leetcode.Linklist;

import java.util.ArrayList;

public class ReverseNodesinkGroup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6};
		ListNode node = new ListNode(array);
		
		ListNode list = reverseKGroup(node,7);
		while(list != null)
		{
			System.out.println(list.val);
			list = list.next;
		}
	}

	/*
	 * ����:����һ��������Ȼ���ҵ�ÿ��k�Ľ�㣬���з�ת
		For example,
		Given this linked list: 1->2->3->4->5

		For k = 2, you should return: 2->1->4->3->5

		For k = 3, you should return: 3->2->1->4->5
		˼·1:��һ��list��ÿһ���ڵ㶼��¼˳�򱣴�����.
		Ȼ���ÿk���ڵ�������з�ת��Ҫ����Ϥ��η�ת���������Ĺ����У���ʱû���о�����û������.
		�ؼ�Ҫά������������ͬʱҪ��¼��һ��k�ڵ�����һ���ڵ㡣
	*/
	 public static ListNode reverseKlist(ListNode head, int k) {
		 
		 if(head == null || k < 2)
		 {
			 return head;
		 }
		 ListNode cur = head;
		 ListNode pre = cur;
		 ListNode next = null;
		 ArrayList<ListNode> list = new ArrayList<ListNode>();
		 int n = 0;
		 while(cur != null && n < k)
		 {
			 if(n > 0)
			 {
				 pre = pre.next;
			 }
			 list.add(cur);
			 cur = cur.next;
			 n++;
		 }
		 if(cur == null)
		 {
			 return head;
		 }
		 else
		 {
			 next = cur;
		 }
		 for(n = n -1; n > 0; n--)
		 {
			cur = list.get(n);
			pre = list.get(n - 1);
			next = cur.next;

			pre.next = next;
			cur.next = head;
			head = cur;
		 }
		 return head;
	}

	 public static ListNode reverseKGroup(ListNode head, int k) {
		 if(head == null || k < 2)
		 {
			 return head;
		 }
		 ListNode cur = head;
		 ListNode pre = cur;
		 ListNode next = null;
		 ListNode start = null;
		 ListNode preStart = null;
		 ArrayList<ListNode> list = new ArrayList<ListNode>();
		 while(cur != null)
		 {
			 list.add(cur);
			 cur = cur.next;
		 }
		 boolean flag = true;//��ǵ�һ�η�ת����Ҫ����head��Ϣ
		 int n = 1;
		 while(true)	
		 {
			 if(n*k > list.size())
			 {
				 break;
			 }
			 int index = (n-1)*k;
			 int imax;
			 start = list.get(index);
			 pre = null;
			 for(index = index+1, imax = 0; imax < k -1; index++,imax++)
			 {
				 cur = list.get(index);
				 if(pre == null)
				 {
					 pre = list.get(index - 1);					 					 
				 }
				 
				 next = cur.next;
				 
				 pre.next = next;
				 cur.next = start;
				 if(flag == false)
				 {
					 preStart.next = cur;					 					 
				 }
				 start = cur;
			 }	
			 if(flag)
			 {
				 head = start;
				 flag = false;
			 }
			 preStart = pre;
			 n++;
		 }
		 return head;
	 }
}
