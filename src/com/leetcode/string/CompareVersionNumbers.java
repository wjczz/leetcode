package com.leetcode.string;

public class CompareVersionNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "1.1";
		String b = "1";
		String c = "0000000";
		System.out.println(compareVersion(a, b));
	}

	/*
	 * 思路笔记： 考虑不周全: 0.10版本 是大于 0.2 版本的
	 * 发现设计根本很有问题，很多情况没有考虑进去
	 * 对版本的比较根本不熟悉，需求不理解。
	 * 
	 * 重新梳理一下：
	 * a.	1.0 == 1
	 * b.	0.1 < 0.1.1
	 * c.	0.10 > 0.2
	 * d.	001.0 < 01.1
	 * e. 	0.1 = 0.1.0.0
	 * f.	1.1 > 1
	 */
	public static int compareVersion(String version1, String version2) {
		if (version1.isEmpty()) {
			if (version2.isEmpty()) {
				return 0;
			} else
				return -1;
		}
		if (version2.isEmpty()) {
			return 1;
		}
		while(!version1.equals("") && !version2.equals(""))
		{
			String x = version1;
			String y = version2;
			if(version1.contains(".") )
			{
				x = version1.substring(0, version1.indexOf("."));
			}
			if(version2.contains("."))
			{
				y = version2.substring(0, version2.indexOf("."));
			}
			int a1 = Integer.parseInt(x);
			int b1 = Integer.parseInt(y);
			if (a1 > b1) {
				return 1;
			} else if (a1 < b1) {
				return -1;
			}
			else
			{
				if(x.equals(version1))
				{
					version1 = "";
				}
				else
				{
					version1 = version1.substring(version1.indexOf(".")+1);
				}
				if(y.equals(version2))
				{
					version2 = "";
				}
				else
				{
					version2 = version2.substring(version2.indexOf(".")+1);
				}
			}
		}
		if(version1.equals("") && version2.equals(""))
		{
			return 0;
		}
		else if(version1.equals(""))
		{
			if(!OnlyHaveZero(version2))
			{
				return -1;
			}
		}
		else
		{
			if(!OnlyHaveZero(version1))
			{
				return 1;
			}
		}
		return 0;
	}

	static boolean OnlyHaveZero(String a)
	{
		boolean result = true;
		for(int i = 0; i < a.length(); i++)
		{
			char ch = a.charAt(i);
			if(ch == '0' || ch == '.')
			{
				continue ;
			}
			else
			{
				result = false;
				break;
			}
		}
		return result;
	}
}
