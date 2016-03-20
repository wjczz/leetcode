package com.leetcode.Linklist;

import java.util.ArrayList;

public class RemoveDuplicatesfromSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,1,2,3,1};
		ListNode node = new ListNode(array);
		ListNode list = deleteDuplicates(node);
		while(list != null)
		{
			System.out.println(list.val);
			list = list.next;
		}
	}

	/*
	 * 需求:去掉单链表中重复的数字. 
	 * 思路:用一个List保存出现过的数字，然后每次遍历该链表的时候
	 * 如果出现过，就直接delete 该节点，否则继续。
	 * 时间复杂度O(n)
	 * 测试用例:
	 * 1.空链表
	 * 2. 1->1->2->3->1->2->3
	 * 3.1->1->2->2->3->3->3
	 * 
	 * (第一次题意理解不好,当1->1->2->3->1->2->3，返回的应该是 1->2->3->1->2->3)
	 * 所以缓存不能用list去保存,用一个变量去保存即可
	 * */
	public static ListNode deleteDuplicatesByArray(ListNode head) {
		if(head == null)
		{
			return head;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		ListNode cur = head;
		ListNode pre = null;
		while(cur != null)
		{
			int val = cur.val;
			if(list.contains(val))
			{
				//remove the node
				pre.next = cur.next;
			}
			else
			{
				list.add(val);
				if(pre == null)
				{
					pre = cur;
				}
				else
				{
					pre = pre.next;
				}
			}
			cur = cur.next;
		}
		return head;
    }
	
	public static ListNode deleteDuplicates(ListNode head)
	{
		if(head == null)
		{
			return head;
		}
		ListNode cur = head;
		ListNode pre = null;
		int cache = Integer.MAX_VALUE;
		while(cur != null)
		{
			int val= cur.val;
			if(cache == val && cache != Integer.MAX_VALUE)
			{
				//remove the node
				pre.next = cur.next;
			}
			else
			{
				cache = val;
				if(pre == null)
				{
					pre = cur;
				}
				else
				{
					pre = pre.next;
				}
			}
			cur = cur.next;
		}
		return head;
	}
}
