package com.leetcode.sort;

public class JavaSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[10];
		for(int i = 0; i < 10; i++)
		{
			nums[i] = (int) (Math.random() * 100);
		}
		System.out.print("排序前:");
		for(int i:nums)
		{
			System.out.print(i + " ");
		}
		InsertSort	(nums);
		System.out.println();
		System.out.print("排序后:");
		for(int i:nums)
		{
			System.out.print(i + " ");
		}
	}
	
	/*普通冒泡排序：*/
	public static void BubbleSort(int[] nums)
	{
		boolean flag = true;
		for(int i = 0, imax = nums.length; i < imax && flag; i++)
		{
			flag = false;
			for(int j = imax-1; j > i; j--)
			{
				if(nums[j] < nums[j - 1])
				{
					swap(nums, j, j - 1);
					flag = true;
				}
			}
		}
	}
	
	/*摆动排序，优化的冒泡排序*/
	public static void ShakerSort(int[] nums)
	{
		int left = 0;
		int right = nums.length - 1;
		while(left < right)
		{
			int mid = 0;
			for(int i = left; i < right; i++)	 // 向右进行气泡排序
			{
				if(nums[i] > nums[i+1])
				{
					swap(nums, i, i+1);
					mid = i+1;	// 记录最后一次所在的状态
				}
			}
			right = mid;
			for(int j = right; j > left; j--) // 向左进行气泡排序
			{
				if(nums[j] < nums[j-1])
				{
					swap(nums, j, j-1);
					mid = j-1;
				}
			}
			left = mid;
		}
	}
	
	public static void swap(int[] nums, int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	/*插入排序*/
	public static void InsertSort(int[] nums)
	{
		int temp = nums[0];
		int j = 0;
		for(int i = 1, imax = nums.length; i < imax; i++)
		{
			if (nums[i] < nums[i - 1]) {
				temp = nums[i];
				for (j = i - 1; j >= 0 && nums[j] > temp; j--) {
					nums[j + 1] = nums[j];
				}
				nums[j + 1] = temp;
			}
		}
	}
	
	/*快速排序*/
	public static void QuickSort(int[] nums)
	{
		
	}
}
