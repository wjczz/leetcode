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

	/* ����:����һ�����֣�Ȼ��������Щ����ƴ�ӳ���������
	 * ˼·:���Ƚ���Щ����ת�����ַ�����Ȼ�����sort��һ�£�Ȼ���ÿ���ַ������������Ϳ�����
	 * ʱ�临�Ӷ�O(nlogn) �ռ临�Ӷ�O(n)
	 * ��������:
	 * 1.  1,2,33,43,34,5
	 * 2.  121, 12       expected:12 121
	 * 3.  1,1,1
	 * 4.  0,0,0
	 * ����Ҫע��:�����sortû����ô�򵥵��ַ����Ƚϡ� ��  121 > 12 ,��ʵ���� 12 121 > 12112
	 * ���������оٳ������������һ��
	 * 	a.�ַ�����С��һ��: 12 ��23
	 * 	b.�ַ�ǰ׺һ��: 121 ��12   ����ԭ���ıȽϾ��� 121 > 12 ����Ȼ��
	 * 		1). 122 �� 12  ��ʱ��  121 >12,���԰���ԭ�����������
	 * 		2). 231 �� 23  С�ڵ�ʱ��, ������  
	 * 		3).	232 �� 23  ���ڵ�ʱ��  ������
	 * 				242 �� 24   Ӧ�÷�����
	 * 				212 �� 21  ����ԭ������
	 * 			����ȥǰ׺��ĸ��,�׸���ĸ��ԭ����һ����ĸ�Ƚϣ�������ڣ�����ԭ���������С�ڣ��򷴹���
	 * 			������ڣ��ͼ�����һ���ıȽ�
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