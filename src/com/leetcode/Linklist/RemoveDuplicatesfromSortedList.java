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
	 * ����:ȥ�����������ظ�������. 
	 * ˼·:��һ��List������ֹ������֣�Ȼ��ÿ�α����������ʱ��
	 * ������ֹ�����ֱ��delete �ýڵ㣬���������
	 * ʱ�临�Ӷ�O(n)
	 * ��������:
	 * 1.������
	 * 2. 1->1->2->3->1->2->3
	 * 3.1->1->2->2->3->3->3
	 * 
	 * (��һ��������ⲻ��,��1->1->2->3->1->2->3�����ص�Ӧ���� 1->2->3->1->2->3)
	 * ���Ի��治����listȥ����,��һ������ȥ���漴��
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
