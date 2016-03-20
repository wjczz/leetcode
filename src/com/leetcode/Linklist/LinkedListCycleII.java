package com.leetcode.Linklist;

import java.util.ArrayList;

public class LinkedListCycleII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * 需求:给你一个单链表，然后判断是否有循环列表，有的话，返回循环的开头。没有的话，返回null.
	 * 要求不能使用过多的空间。空间复杂度为O(1)
	 * 思路:
	 * 	 1.直接循环链表，判断有没有空节点或者链表出现 节点,有的话直接返回此节点
	                  时间复杂度O(n) 空间复杂度也是O(n)
	     2.直接
	 * */
public ListNode detectCycle(ListNode head) {
	ArrayList<ListNode> array = new ArrayList<ListNode>(); 
	ListNode cur = head;
	int index = 0;
	while (cur != null) {
		if (cur.next == null) {
			return null;
		}
		if (array.contains(cur)) {
			return cur;
		}
		else
		{
			array.add(cur);
		}
		cur = cur.next;
		index++;
	}
		return null;   
    }



}
