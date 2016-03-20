package com.leetcode.Linklist;

import java.util.Vector;

public class ReorderList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5};
		ListNode node = new ListNode(array);
		reorderList(node);
	}
	
	/*
	 * 需求：根据题意重新为单链表排序
	 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
	 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
	 * 思路: 
	 * 1.用一个List把所有Node都存储起来,然后直接索引取相应的节点
	 *  	时间复杂度O(n)
	 *    注:题目要求只能在head操作
	 * 测试用例:
	 * 	1.空链表
	 * 	2.普通链表
	 */
	public static void reorderList(ListNode head) {
        if(head == null || head.next == null)
        {
        	return;
        }
		Vector<ListNode> vector = new Vector<ListNode>();
        ListNode temp = head;
        int length = 0;
        while(temp != null)
        {
        	length++;
        	vector.add(temp);
        	temp = temp.next;
        }
        ListNode cur = head;
        cur.next = vector.lastElement();
        cur = cur.next;
        for(int i = 1, j = length - 2; i <= j; i++, j--)
        {
        	if(i == j)
        	{
        		cur.next = vector.get(j);
        		cur = cur.next;  
        	}
        	else
        	{
        		cur.next = vector.get(i);
        		cur = cur.next;
        		cur.next = vector.get(j);
        		cur = cur.next;        		
        	}
        }
        cur.next = null;
        while(head != null)
		{
			System.out.println(head.val);
			head = head.next;
		}
    }
}
