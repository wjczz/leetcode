package com.leetcode.Linklist;

public class SwapNodesinPairs {

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2};
		ListNode node = new ListNode(array);
		ListNode list = swapPairs(node);
		while(list != null)
		{
			System.out.println(list.val);
			list = list.next;
		}
	}

	/*
	���������ÿ2����㣬���໥����һ��val
	���������
		1.ֻ��1����������
		2.>= 2����������
			a.����������
			b.����������
		//��ʱ����ȱ��һ�����
		3. ������Ĵ���
	 */
	 public static ListNode swapPairs(ListNode head) {
		 ListNode result = null;
		 
		 ListNode pre = null;
		 ListNode swap1 = null;
		 ListNode swap2 = null;
		 ListNode next = null;
		 if(head == null || head.next == null)
		 {
			 return head;
		 }
		 swap1 = head;	
		 swap2 = swap1.next;
		 result = swap2;
		 while(true)
		 {
			 next = swap2.next;
			 			 
			 //swap
			 swap2.next = swap1;			 
			 swap1.next = next;
			 if(pre != null)
			 {
				 pre.next = swap2;
			 }
			 pre = swap1;
			 
			 
			 if(next != null && next.next != null)
			 {
				//next swap
				 swap1 = next;
				 swap2 = next.next;	 
			 }
			 else
			 {
				 break;	
			 }
			 
		 }
		 
		 return result; 
		 
	 }
}
