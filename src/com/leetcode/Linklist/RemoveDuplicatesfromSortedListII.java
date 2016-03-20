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
	 * ����:Ҫ��ȥ���������ֻҪ���ظ����ֵĽ��.
	 * ˼·:
	 * 1.����һ�ε�����,��һ��������¼������ǰ��ֵ,���Ҽ�¼��һ�γ��ֵ�ListNode ָ��ڵ�,����һ���ڵ�,�������ظ���ʱ�򣬾�ɾ����.
	 * 	ʱ�临�Ӷ�ΪO(n)
	 * (����:���ַ����㷨���ڸ��ӣ�����ͷ���ظ���ʱ�� ����β���ظ���ʱ���޷�ֱ��ɾ����Щ�ڵ㡣�ر�����β��ʱ����Ҫһ������ȥ��¼�ǲ����ظ��� ��ͷҲ����Ҫ�и�����ȥ��¼)
	 * �����Ͳ����У���Ϊ���㷢���иý�����ظ���ʱ�����޷�֪����һ��������Ϣ�� ɾ������������Ҫ֪��  ���������һ��������Ϣ��
	 * 
	 * 2.����һ�ε�������һ��List��¼ÿһ������ȥ�������ٱ���һ�Σ��Ѹ����Ľ������µ�����
	 * 	���ģ�ÿһ������Ƿ�ȥ������Ӧ������һ��������һ������val ������
	 * 
	 * ʱ�临�Ӷ�O(2n) = O(n)
	 * ��������:
	 * 1.������
	 * 2.�������ظ��ڵ� [1,1,2,2], [1,1,2,2,1,1]
	 * 3.������ظ��ڵ� [1,1,3,2,2,1,1]
	 * 4.���ظ��ڵ� [1,2,3,4]
	 * 5.�������ظ������ϲ��ظ� [1,1,2,2,1,2]
	 * 6.��ͷ���ظ�����β���ظ���
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
		//************����˼��
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
		//************����˼��
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
