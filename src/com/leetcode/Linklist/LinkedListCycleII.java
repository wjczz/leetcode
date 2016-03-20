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
	 * ����:����һ��������Ȼ���ж��Ƿ���ѭ���б��еĻ�������ѭ���Ŀ�ͷ��û�еĻ�������null.
	 * Ҫ����ʹ�ù���Ŀռ䡣�ռ临�Ӷ�ΪO(1)
	 * ˼·:
	 * 	 1.ֱ��ѭ�������ж���û�пսڵ����������� �ڵ�,�еĻ�ֱ�ӷ��ش˽ڵ�
	                  ʱ�临�Ӷ�O(n) �ռ临�Ӷ�Ҳ��O(n)
	     2.ֱ��
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
