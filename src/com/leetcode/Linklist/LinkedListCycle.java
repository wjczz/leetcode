package com.leetcode.Linklist;

import java.util.ArrayList;

public class LinkedListCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2};
		ListNode node = new ListNode(array);
//		node = node.getCycle(node);
		boolean is= hasCycle(node);
		
		System.out.println(is);
		
	}

	/*
	 * 题意:给你一个单链表，判断单链表，有没有存在循环
	        思路:
	   1.直接循环链表，判断有没有空节点或者链表出现 节点。
	             时间复杂度O(n) 空间复杂度也是O(n)
	   	   评价:内存限制,不可行
	   2.参考网上的做法:
	   		设置两个指针P1，P2。
			a. 排除一个特殊情况，就是只有三个元素（实际上只有两个），第二个元素的next是第一个元素！
				P1指向第一个元素，p1的next为第二个元素，P1的next的next原色为第三个元素。令P2指向第三个元素，看看他们相等与否？
			b. 如果不等，把P1指向P1的next元素（后移一个元素）；P2指向next的next元素（后移两个元素）。
				如果存在循环，那么P2先进入循环并再也不会出来，而后P1进入循环，周而复始，其中一个指针终会追上另外一个，出现P1==P2的情况，则存在循环！
				否则，P2首先出现NULL，则说明该链表不存在循环。
			时间复杂度:O(4*n) = O(n) 空间复杂度O(1)
	 */
	public static boolean hasCycleByArray(ListNode head) {
	     long begin = System.currentTimeMillis(); // 这段代码放在程序执行前

		ArrayList<ListNode> array = new ArrayList<ListNode>(); 
		ListNode cur = head;
		int index = 0;
		while (cur != null) {
			if (cur.next == null) {
				return false;
			}
			if (array.contains(cur)) {
				System.out.println(index);
				System.out.println(cur.val);
				long end = System.currentTimeMillis() - begin; // 这段代码放在程序执行后
				System.out.println("耗时：" + end + "毫秒");
				return true;
			}
			else
			{
				array.add(cur);
			}
			cur = cur.next;
			index++;
		}
		   long end = System.currentTimeMillis() - begin; // 这段代码放在程序执行后
		     System.out.println("耗时：" + end + "毫秒");
		return false;
	}

	public static boolean hasCycle(ListNode head)
	{
		if(head == null || head.next == null)
		{
			return false;
		}
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && slow != null)
		{
			slow = slow.next;
			if(fast.next == null || fast.next.next == null || slow == null)
			{
				return false;
			}
			fast = fast.next.next;
			if(fast == slow)
			{
				return true;
			}
		}
		
		return false;
	}
}
