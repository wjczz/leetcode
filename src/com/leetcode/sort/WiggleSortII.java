package com.leetcode.sort;

import java.util.Arrays;

public class WiggleSortII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,4,5,6};
		wiggleSort(nums);
		for(int i:nums)
		{
			System.out.print(i + " ");
		}
	}

	/*
	 * 需求:要求给你一数组，然后按照以下规则去排序 
	 * nums[0] < nums[1] > nums[2] < nums[3]....
	 * 时间复杂度必须为O(n),空间复杂度为O(1)
	 * 思路:
	 *  把数组升序排序，然后按照从新遍历一遍
	 *  当下标i为奇数的话，就判断 nums[i] 会不会大于num[i+1],会的话，就不管。
	 *  如果是等于的话，就往下寻找 刚好比nums[i]大的数，并且交换位置。
	 *  如果是小于的话，则交互位置
	 *  测试用例:
	 *  1.{4,6,5,5} 应该变为  5,6,4,5
	 *  
	 *  思路2：(参考网上的思路)
	 *  把一个排好序的数组分成2分，然后遍历数组，奇数的取前半部分的值，偶数的，取后半部分的值，
	 *  这样就能保证  nums[0] < nums[1] > nums[2] < nums[3]
	 */
	public static void wiggleSort(int[] nums)
	{
		Arrays.sort(nums);
		int length = nums.length;
		int begin = (length+1) / 2 - 1;
		int end = length - 1;
		int[] copyNums = nums.clone();
		for(int i = 0, imax = length; i < imax; i++)
		{
			if(i % 2 == 0)
			{
				nums[i] = copyNums[begin];
				begin--;
			}
			else
			{
				nums[i] = copyNums[end];
				end--;
			}
		}
	}

	public static void wiggleSortDonotPass(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0, imax = nums.length; i < imax; i++)
        {
        	if(i % 2 == 1 && (i+1) < imax)
        	{
        		if(nums[i] < nums[i+1])
        		{
        			swap(nums, i , i+1);
        		}
        		else if(nums[i] == nums[i+1])
        		{
        			for(int j = i; j <imax; j++)
        			{
        				if(nums[j] > nums[i])
        				{
        					swap(nums, i , j);
        					break;
        				}
        			}
        		}
        	}
        }
    }
	
	public static void swap(int[] nums, int i, int j)
	{
//		不搞 一个新的中间变量的话，这样交换 会溢出~~~~~
//		nums[i] = nums[i] +  nums[j];
//		nums[j] = nums[i] - nums[j];
//		nums[i] = nums[i] - nums[j];
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
