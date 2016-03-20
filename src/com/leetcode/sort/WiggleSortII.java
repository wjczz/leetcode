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
	 * ����:Ҫ�����һ���飬Ȼ�������¹���ȥ���� 
	 * nums[0] < nums[1] > nums[2] < nums[3]....
	 * ʱ�临�Ӷȱ���ΪO(n),�ռ临�Ӷ�ΪO(1)
	 * ˼·:
	 *  ��������������Ȼ���մ��±���һ��
	 *  ���±�iΪ�����Ļ������ж� nums[i] �᲻�����num[i+1],��Ļ����Ͳ��ܡ�
	 *  ����ǵ��ڵĻ���������Ѱ�� �պñ�nums[i]����������ҽ���λ�á�
	 *  �����С�ڵĻ����򽻻�λ��
	 *  ��������:
	 *  1.{4,6,5,5} Ӧ�ñ�Ϊ  5,6,4,5
	 *  
	 *  ˼·2��(�ο����ϵ�˼·)
	 *  ��һ���ź��������ֳ�2�֣�Ȼ��������飬������ȡǰ�벿�ֵ�ֵ��ż���ģ�ȡ��벿�ֵ�ֵ��
	 *  �������ܱ�֤  nums[0] < nums[1] > nums[2] < nums[3]
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
//		���� һ���µ��м�����Ļ����������� �����~~~~~
//		nums[i] = nums[i] +  nums[j];
//		nums[j] = nums[i] - nums[j];
//		nums[i] = nums[i] - nums[j];
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
