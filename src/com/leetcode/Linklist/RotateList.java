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
	 * ����Ҫ������һ��������Ȼ������һ��k����ʾ����β��ʼ����תk�ڵ�
	 * ˼·��
	 * 	1.�ȷ�������,��ƫ��k����㣬��ƴ�ӳ��µ�����
	 * 		ʱ�临�Ӷ�O(n)
	 * 	2.�ĳ�ѭ��������������ȣ������ڴ���ͷƫ�� n-k���ڵ�
	 * 		ʱ�临�Ӷ�O(n) 
	 * ����������
	 * 	1.������
	 * 	2.k �����������Χ��
	 * 	3.k �����������Χ��(��Ҫȡ��)
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
        //���ѭ������
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

