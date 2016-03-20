package com.leetcode.Linklist;

public class InsertionSortList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,4,3};
		ListNode node = new ListNode(array);
		ListNode list = insertionSortList(node);
		while (list != null) {
			System.out.println(list.val);
			list = list.next;
		}
	}

	/*
	 * 需求:插入排序一个链表 思路：直接插入排序（升序）
	 */
	public static ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode result = head;
		ListNode pre = head;
		ListNode cur = pre.next;
		int index = 1;
		while (cur != null) 
		{
			int val = cur.val;
			if (cur.val < pre.val) 
			{
				ListNode curSonNode = result;
				ListNode preSonNode = null;
				for (int i = 0; i < index; i++) 
				{
					if (val < curSonNode.val) 
					{
						pre.next = cur.next;
						if (preSonNode == null) 
						{
							cur.next = curSonNode;
							result = cur;
						} 
						else 
						{
							preSonNode.next = cur;
							cur.next = curSonNode;
						}
						break;
					}
					preSonNode = curSonNode;
					curSonNode = curSonNode.next;
				}
				cur = pre.next;
			}
			else
			{
				pre = cur;
				cur = cur.next;				
			}
			index++;
		}
		return result;
	}
}
