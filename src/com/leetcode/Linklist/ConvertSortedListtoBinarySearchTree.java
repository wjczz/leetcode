package com.leetcode.Linklist;

import java.util.ArrayList;

public class ConvertSortedListtoBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4};
		ListNode node = new ListNode(array);
		TreeNode tree = sortedListToBST(node);
	}

	/*
	 * ����:��һ��������Ȼ��ת���ɸ߶�ƽ��Ķ�����
	 * ˼·:
	 * 		1.�����ҵ��м�ڵ�
	 * 		2.�÷��η��ݹ飬�ҵ���Ӧ�Ľڵ�
	 * 	         ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(n)
	 * */
	public static TreeNode sortedListToBST(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        ListNode cur = head;
        while(cur != null)
        {
        	list.add(cur);
        	cur = cur.next;
        }
        int length = list.size();
        int begin = 0;
        int end = length -1;
        TreeNode result = getTreeNode(list, begin, end);
		return result;
    }
	
	public static TreeNode getTreeNode(ArrayList<ListNode> list, int begin, int end)
	{
		if(begin > end)
		{
			System.out.println("null");
			return null;
		}
		int index = (begin + end ) / 2;
		TreeNode tree = new TreeNode(list.get(index).val);
		System.out.println(tree.val);
		tree.left = getTreeNode(list, begin, index-1);
		tree.right = getTreeNode(list, index+1, end);
		return tree;
	}
}

class TreeNode {
	  int val;
	  TreeNode left;
	  TreeNode right;
	  TreeNode(int x) { val = x; }
	 }