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
	 * ���󣺸�����������Ϊ����������
	 * Given a singly linked list L: L0��L1������Ln-1��Ln,
	 * reorder it to: L0��Ln��L1��Ln-1��L2��Ln-2����
	 * ˼·: 
	 * 1.��һ��List������Node���洢����,Ȼ��ֱ������ȡ��Ӧ�Ľڵ�
	 *  	ʱ�临�Ӷ�O(n)
	 *    ע:��ĿҪ��ֻ����head����
	 * ��������:
	 * 	1.������
	 * 	2.��ͨ����
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
