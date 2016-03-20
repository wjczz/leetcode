package com.leetcode.math;

public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ans = {2,7,11,15};
		twoSum(ans,9);
		
	}

	static  public int[] twoSum(int[] nums, int target) {
	        int[] ans = new int[2];
	        for(int i = 0;i < nums.length;i++)
	        {
	        	for(int j = i+1;j < nums.length;j++)
	        	{
	        		int sum = nums[i] + nums[j];
	        		if(sum == target)
	        		{
	        			ans[0] = i + 1;
	        			ans[1] = j + 1;
	        			System.out.println(ans[0]+","+ans[1]);
	        			return ans;
	        		}
	        	}
	        }
	        return ans;
	    }
}
