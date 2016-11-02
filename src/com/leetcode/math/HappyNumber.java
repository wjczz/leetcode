package com.leetcode.math;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class HappyNumber {

	/**
	 * @param args
	 * 这道题其实不难，一开始 采用素数筛选法，把int 范围内的数字都记录起来，判断有没有循环，这样程序运行的时候，是30ms 左右，所以一直超时
	 * 最后想了想，采用map保存记录 出现过的数字，这样性能就快多了，不需要每次运行都去new 一大波无用的数字
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     long begin = System.currentTimeMillis(); // 这段代码放在程序执行前

			if(isHappy(693))
			{
				System.out.println(237 + "是 happy num");
			}
		     long end = System.currentTimeMillis() - begin; // 这段代码放在程序执行后
		     System.out.println("耗时：" + end + "毫秒");
	}

	public static boolean isHappy(int n) {
		HashMap<Integer, Integer> hash_param = new HashMap<Integer, Integer>();
        int num = n;
        while(true)
        {
        	if(num == 1)
        	{
        		return true;
        	}
        	if(hash_param.containsKey(num))
        	{
        		return false;
        	}
        	hash_param.put(num, 1);
        	num = DecomposeNum(num);	
        }
    }
	
	public static int DecomposeNum(int n)
	{
		int num = 0;
		while(n != 0)
		{
			int a = n % 10;
			num += a * a;
			n = n / 10;
		}
		return num;
	}
}
