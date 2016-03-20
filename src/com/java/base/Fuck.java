package com.java.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import com.sun.xml.internal.ws.util.StringUtils;

public class Fuck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {"1","4","1","4","2"};
		getSort(str);
//		ArrayList list = new ArrayList<>();
//		list.iterator();
		Set<Integer> set = new HashSet();
		set.add(1);
		for(Integer i:set)
		{
			System.out.println(i);
		}

		Iterator it = set.iterator();
		while(it.hasNext())
		{
			Integer key = (Integer)it.next();
			System.out.println(key);
		}
		Vector<Integer> v = new Vector<Integer>();
		v.add(2);
		for(int i:v)
		{
			System.out.println(i);
		}
	}

	/*
	 * 需求:这道题就是有一些item,分别有itemId 和parentId,当item 没有parent的时候，为null.
	        按wbs的格式给这些item排个序. 比如1.1, 1.2 ,1.2.1,2.2 2.3
	*/
	public static ArrayList<Item> Sort(ArrayList<Item> lists)
	{

		return null;
	}

	public static int Find(int x)
	{

		return 0;
	}

	/*需求:任意给你一组字符{1,2,3,4,5}，让你输出出现字符的最多的次数，
	 * 并且出现字符数值最大的字符是多少
	 * 思路:用HashMap<String,int> key：字符，value为次数.后遍历该HashMap,则可知道出现该数值是多少了
	 * 时间复杂度O(n)
	*/
	/**
	 * @param str
	 */
	public static void getSort(String[] str)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String s:str)
		{
			if(map.containsKey(s))
			{
				int count = map.get(s);
				count++;
				map.put(s, count);
			}
			else
			{
				map.put(s, 1);
			}
		}

		String result = "";
		int count = 0;
		try
		{
			for (String s : map.keySet()) {
				int value = map.get(s);
				if (value > count
						|| (value == count && Integer.valueOf(s) > Integer
						.valueOf(result))) {
					result = s;
					count = value;
				}
			}

			Iterator it = map.keySet().iterator();
			while(it.hasNext())
			{
				String key = (String)it.next();
				int value = map.get(key);
				System.out.println("key: " +key + " num: " + value );
			}
		}
		catch(Exception e)
		{
			System.out.println("字符串含有非数字 throw " + e.getMessage());
			//throw e;
		}
		System.out.println(result+":"+count);
	}
}





