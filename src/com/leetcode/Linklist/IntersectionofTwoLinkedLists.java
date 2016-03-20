package com.leetcode.Linklist;

public class IntersectionofTwoLinkedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = { 1, 2, 3, 4, 5, 6 };
		ListNode head1 = new ListNode(array1);
		int[] array2 = { 7,8 };
		ListNode head2 = new ListNode(array2);
		ListNode list = getIntersectionNode(head1, head2);
		while (list != null) {
			System.out.println(list.val);
			list = list.next;
		}
	}

	/*
	 * ������������Ǵ�2�������������ҳ� ���н����㣬�������һ���µĵ����� 
	 * ����������
	 *  1.A || B Ϊ������ 
	 *  2.A��B��������������
	 * 		a.�н����� 
	 * 		b.û�н����� 
	 * 3.A,B������������ 
	 * 		a.�н�����
	 * 		b.û�н�����
	 */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headA == null)
		{
			return null;
		}
		ListNode result = null;
		ListNode result_cur = null;
		ListNode node1 = headA;
		ListNode node2 = headB;
		int length1 = getlength(headA);
		int length2 = getlength(headB);
		if (length1 > length2) {
			int count = length1 - length2;
			node1 = getMoveListNode(count, node1);
		} else if (length1 < length2) {
			int count = length2 - length1;
			node2 = getMoveListNode(count, node2);
		}
		while (node1 != null && node2 != null) {
			if (node1.val == node2.val) {
				if (result != null) {
					result_cur.next = new ListNode(node1.val);
					result_cur = result_cur.next;
				} else {
					result = new ListNode(node1.val);
					result_cur = result;
				}
			}
			node1 = node1.next;
			node2 = node2.next;
		}
		return result;
	}

	public static int getlength(ListNode head) {
		ListNode node = head;
		int count = 0;
		while (node != null) {
			node = node.next;
			count++;
		}
		return count;
	}

	public static ListNode getMoveListNode(int count, ListNode node) {

		while (count > 0) {
			node = node.next;
			count--;
		}
		return node;
	}
}
