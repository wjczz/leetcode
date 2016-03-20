package com.leetcode.Linklist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array =  {2,234,5,7,3};
		ListNode node = new ListNode(array);
//		ListNode list = sortList(node);
		ListNode list = sortListByArray(node);
		while(list != null)
		{
			System.out.println(list.val);
			list = list.next;
		}
	}

	/*
	 * 需求：对单链表进行排序
	 * 时间复杂度：O(nlogn)
	 * 思路:
	 * 1.采用Array.sort: 底层采用快速排序  时间复杂度为O(nlogn)
	 * 2.采用优先队列. 时间复杂度O(nlogn)
	 * 测试用例:
	 * 一连串的数字
	 */
	public static ListNode sortList(ListNode head) {
        Comparator<ListNode> ListComp = new Comparator<ListNode>() {
        	public int compare(ListNode x, ListNode y)
        	{

        		int a = x.val;
        		int b = y.val;
        		if(a > b)
        		{
        			return 1;
        		}
        		else if(a == b)
        		{
        			return 0;
        		}
        		else
        		{
        			return -1;
        		}
        	}
        };
        
        Queue <ListNode> priorityQueue = new PriorityQueue<ListNode>(11, ListComp);
		ListNode temp = head;
		while(temp != null)
		{
			priorityQueue.add(temp);
			temp = temp.next;
		}
        ListNode result = null;
        ListNode result_next = null;
        while(!priorityQueue.isEmpty())
        {
        	ListNode n = priorityQueue.poll();
        	if(result != null)
        	{
        		result_next.next = n;
        		result_next = result_next.next;
        	}
        	else
        	{
        		result = n;
        		result_next = result;
        	}
        }
        if(result_next != null)
        {
        	result_next.next = null;
        }
        return result;
    }

	public static ListNode sortListByArray(ListNode head)
	{
	    ListNode[] array = new ListNode[5];
	    ListNode temp = head;
	    int i = 0;
	    while(temp != null)
	    {
	    	array[i] = temp;
	    	temp = temp.next;
	    	i++;
	    }
	    Comparator<ListNode> MyCompartor = new MyCompartor();
		Arrays.sort(array, 0, i, MyCompartor); //因为申请了很大的数组，所以有的元素是null,不能去比较
	    ListNode result = null;
        ListNode result_next = null;
	    for(int j = 0; j < i; j++) //注意这里要 j < i
	    {
	    	ListNode n = array[j];
        	if(result != null)
        	{
        		result_next.next = n;
        		result_next = result_next.next;
        	}
        	else
        	{
        		result = n;
        		result_next = result;
        	}
        }
        if(result_next != null)
        {
        	result_next.next = null;
        }
		return result;
	}
}

class MyCompartor implements Comparator<ListNode>
{
	@Override
	public int compare(ListNode x, ListNode y)
	{
		int a = x.val;
		int b = y.val;
		if(a > b)
		{
			return 1;
		}
		else if(a == b)
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}
}
