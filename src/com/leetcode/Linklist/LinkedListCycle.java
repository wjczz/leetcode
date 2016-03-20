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
	 * ����:����һ���������жϵ�������û�д���ѭ��
	        ˼·:
	   1.ֱ��ѭ�������ж���û�пսڵ����������� �ڵ㡣
	             ʱ�临�Ӷ�O(n) �ռ临�Ӷ�Ҳ��O(n)
	   	   ����:�ڴ�����,������
	   2.�ο����ϵ�����:
	   		��������ָ��P1��P2��
			a. �ų�һ���������������ֻ������Ԫ�أ�ʵ����ֻ�����������ڶ���Ԫ�ص�next�ǵ�һ��Ԫ�أ�
				P1ָ���һ��Ԫ�أ�p1��nextΪ�ڶ���Ԫ�أ�P1��next��nextԭɫΪ������Ԫ�ء���P2ָ�������Ԫ�أ���������������
			b. ������ȣ���P1ָ��P1��nextԪ�أ�����һ��Ԫ�أ���P2ָ��next��nextԪ�أ���������Ԫ�أ���
				�������ѭ������ôP2�Ƚ���ѭ������Ҳ�������������P1����ѭ�����ܶ���ʼ������һ��ָ���ջ�׷������һ��������P1==P2������������ѭ����
				����P2���ȳ���NULL����˵������������ѭ����
			ʱ�临�Ӷ�:O(4*n) = O(n) �ռ临�Ӷ�O(1)
	 */
	public static boolean hasCycleByArray(ListNode head) {
	     long begin = System.currentTimeMillis(); // ��δ�����ڳ���ִ��ǰ

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
				long end = System.currentTimeMillis() - begin; // ��δ�����ڳ���ִ�к�
				System.out.println("��ʱ��" + end + "����");
				return true;
			}
			else
			{
				array.add(cur);
			}
			cur = cur.next;
			index++;
		}
		   long end = System.currentTimeMillis() - begin; // ��δ�����ڳ���ִ�к�
		     System.out.println("��ʱ��" + end + "����");
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
