package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/*
 * http://blog.csdn.net/whucyl/article/details/23524045
*/
	public class MedianofTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 1};
		int[] b = {1, 1};
	//	System.out.println(FindKth(a, b,2));
		System.out.println(FindKth(a, b,3));
		System.out.println(FindMedianSortedArrays(a, b));
	}

	 public static double FindMedianSortedArrays(int[] nums1, int[] nums2) {
		 int sum1 = nums1.length;
		 int sum2 = nums2.length;
		 double result = 0;
		 int sum = sum1 + sum2;
		 if(sum % 2 ==0)
		 {
			 result = (FindKth(nums1, nums2, sum / 2) + FindKth(nums1, nums2, sum / 2 +1)) / 2.0;
		 }
		 else
		 {
			 result = FindKth(nums1, nums2, sum / 2 +1);
		 }
		 return result;
	 }
	 
	 //k 是第几个，非下标
	 public static int FindKth(int[] a, int[] b, int k)
	 {
		int i = k / 2;
		if(a.length == 0)
		{
			return b[k - 1];
		}
		if(b.length == 0)
		{
			return a[k - 1];
		}
		if(k == 1)
		{
			return Math.min(a[0], b[0]);
		}
		if(i > a.length)
		{
			i = a.length;
		}
		else if(i > b.length)
		{
			i = b.length;
		}
		if(a[i - 1] <= b[i - 1])
		{
			//remove a(0 ~ i - 1)
			int[] c = new int[a.length];
			if(i == a.length) 
			{
				c= new int[0];			
			}
			else
			{
				c= new int[a.length - i];
			}
			for(int j = 0, count = i;  count < a.length; j++, count++)
			{
				c[j] = a[count];
			}
			return FindKth(c, b, k - i);
		}
		else{
			//remove b(0 ~ i - 1)
			int[] c = new int[b.length];
			if(i == b.length) 
			{
				c= new int[0];			
			}
			else
			{
				c= new int[b.length - i];
			}
			for(int j = 0, count = i; count < b.length; j++, count++)
			{
				c[j] = b[count];
			}
			return  FindKth(a, c, k - i);
		}	
	 }
	 
}
