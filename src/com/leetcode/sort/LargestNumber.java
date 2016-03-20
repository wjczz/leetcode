package com.leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.sun.org.apache.xml.internal.utils.StringVector;

public class LargestNumber {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {232,23,234};
		String result = largestNumber(num);
		System.out.println(result);
	}

	/* 需求:给你一组数字，然后求由这些数字拼接成最大的数字
	 * 思路:首先将这些数字转换成字符串，然后进行sort得一下，然后把每个字符串连接起来就可以了
	 * 时间复杂度O(nlogn) 空间复杂度O(n)
	 * 测试数据:
	 * 1.  1,2,33,43,34,5
	 * 2.  121, 12       expected:12 121
	 * 3.  1,1,1
	 * 4.  0,0,0
	 * 这里要注意:这里的sort没有那么简单的字符串比较、 当  121 > 12 ,但实际上 12 121 > 12112
	 * 这里我们列举出各种情况讨论一下
	 * 	a.字符串大小不一样: 12 和23
	 * 	b.字符前缀一样: 121 和12   按照原来的比较就是 121 > 12 ，不然。
	 * 		1). 122 和 12  这时候  121 >12,可以按照原来的排序规则
	 * 		2). 231 和 23  小于的时候, 反过来  
	 * 		3).	232 和 23  等于的时候  反过来
	 * 				242 和 24   应该反过来
	 * 				212 和 21  按照原来排序
	 * 			当除去前缀字母后,首个字母和原来第一个字母比较，如果大于，按照原来排序规则，小于，则反过来
	 * 			如果等于，就继续下一个的比较
	*/	
	public static String largestNumber(int[] nums) {
        ArrayList<String> strs = new ArrayList<String>();
        for(int i:nums)
        {
        	strs.add(String.valueOf(i));
        }
        String result = "";
        MyComparator comparator = new MyComparator(); 
        Collections.sort(strs, comparator);
        for(String s:strs)
        {
        	result += s;
        }
        String str = result.substring(0,result.length()-1).replaceFirst("^0*", "");
        
        return str + result.charAt(result.length()-1);
    }
	
}

class MyComparator implements Comparator<String>
{

//	@Override
//	public int compare(String o1, String o2) {
//		// TODO Auto-generated method stub
//		int i = 0;
//		int j = 0;
//		for(i = 0, j = 0; i < o1.length() && j < o2.length(); i++, j++)
//		{
//			if(o1.charAt(i) < o2.charAt(j))
//			{
//				return 1;
//			}
//			else if(o1.charAt(i) > o2.charAt(j))
//			{
//				return -1;
//			}
//		}
//		if(i == o1.length() && j == o2.length())
//		{
//			return 0;
//		}
//		else if(i == o1.length())
//		{
//			return compare(o1,o2.substring(j));
//		}
//		else if(j == o2.length())
//		{
//			return compare(o1.substring(i),o2);
//		}
//		
//		return 0;
//	}
//	
	@Override
	public int compare(String o1, String o2)
	{
		String x = o1.concat(o2);
		String y = o2.concat(o1);
		return y.compareTo(x);
	}
}