package com.leetcode.Linklist;

public class RotateList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1};
		ListNode node = new ListNode(array);
		ListNode list = rotateRight(node,3);
		while(list != null)
		{
			System.out.println(list.val);
			list = list.next;
		}
	}
	
	/*
	 * 需求：要求输入一个单链表，然后输入一个k，表示从链尾开始，旋转k节点
	 * 思路：
	 * 	1.先反序链表,再偏移k个结点，再拼接成新的链表
	 * 		时间复杂度O(n)
	 * 	2.改成循环链表，求出链表长度，接着在从链头偏移 n-k个节点
	 * 		时间复杂度O(n) 
	 * 测试用例：
	 * 	1.空链表
	 * 	2.k 在链表个数范围内
	 * 	3.k 在链表个数范围外(需要取余)
	 */
	public static ListNode rotateRight(ListNode head, int k) {
        if(head == null)
        {
        	return head;
        }
        ListNode temp = head;
        int length = 1;
        while(temp.next != null)
        {
        	length++;
        	temp = temp.next;
        }
        k %= length;
        //变成循环链表
        temp.next = head;
        int i = length - k;
        ListNode result = head;
        ListNode reil = head;
        while(i > 0)
        {
        	i--;
        	if(i == 0)
        	{
        		reil = result;
        	}
        	result = result.next;
        }
        reil.next = null;
		return result;
    }
}

