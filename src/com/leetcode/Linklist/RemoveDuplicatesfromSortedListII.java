package com.leetcode.Linklist;

import java.util.ArrayList;

public class RemoveDuplicatesfromSortedListII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,1};
		ListNode node = new ListNode(array);
		ListNode list = deleteDuplicates(node);
		while(list != null)
		{
			System.out.println(list.val);
			list = list.next;
		}
	}
	
	/*
	 * 需求:要求去除单链表的只要有重复数字的结点.
	 * 思路:
	 * 1.遍历一次单链表,用一个变量记录起来当前的值,并且记录第一次出现的ListNode 指针节点,和下一个节点,当出现重复的时候，就删除掉.
	 * 	时间复杂度为O(n)
	 * (评价:这种方法算法过于复杂，当链头有重复的时候 和链尾有重复的时候，无法直接删除这些节点。特别是链尾的时候，需要一个变量去记录是不是重复。 链头也是需要有个变量去记录)
	 * 根本就不可行，因为当你发现有该结点有重复的时候，你无法知道上一个结点的信息。 删除结点的条件需要知道  这个结点的上一个结点的信息。
	 * 
	 * 2.遍历一次单链表，用一个List记录每一个结点的去与留，再遍历一次，把该留的结点组成新的链表。
	 * 	核心：每一个结点是否去留，都应该由上一个结点和下一个结点的val 决定。
	 * 
	 * 时间复杂度O(2n) = O(n)
	 * 测试用例:
	 * 1.空链表
	 * 2.连续有重复节点 [1,1,2,2], [1,1,2,2,1,1]
	 * 3.间断有重复节点 [1,1,3,2,2,1,1]
	 * 4.无重复节点 [1,2,3,4]
	 * 5.连续有重复，隔断不重复 [1,1,2,2,1,2]
	 * 6.起头有重复，结尾有重复的
	 * */
	public static ListNode deleteDuplicates(ListNode head)
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		ArrayList<Boolean> array = new ArrayList<Boolean>();//true:have duplicate  false:have no duplicate
		ListNode cur = head;
		int val = Integer.MAX_VALUE;
		int index = 0;
		//************核心思想
		while(cur != null)
		{
			int temp = cur.val;
			if(temp == val)
			{
				array.add(index, true);		
			}
			else
			{
				val = temp;
				if(cur.next != null && cur.next.val == val)
				{
					array.add(index, true);
				}
				else
				{
					array.add(index, false);
				}	
				
			}
			cur = cur.next;
			index++;
		}
		//************核心思想
		ListNode result = null;
		ListNode node = result;
		cur = head;
		for(int i = 0; i < index; i++)
		{
			if(!array.get(i))
			{
				if(result == null)
				{
					result = cur;
					node = result;
				}
				else
				{
					node.next = cur;
					node = node.next;
				}
			}
			cur = cur.next;
		}
		if(node != null)
		{
			node.next = null;			
		}
		return result;
	}
}
