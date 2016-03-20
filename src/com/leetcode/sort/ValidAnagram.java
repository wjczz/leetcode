package com.leetcode.sort;

import java.util.ArrayList;

public class ValidAnagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "rat";
		String t = "art";
		System.out.println(isAnagram(s, t));
	}

	/*
	 * 需求：要求匹配2个字符串》. 
	 * For example, 
	 * s = "anagram", t = "nagaram", return true. 
	 * s = "rat", t = "car", return false.
	 * 思路:用个List记录用了多少个字符，然后再去遍历另外个字符串，找到一个就剪掉一个 
	 * 时间复杂度度O(n+m) 空间复杂度O(n)
	 * 测试用例：
	 * 1.s = "anagram", t = "nagaram",
	 * 2.s = "rat", t = "car"
	 */
	public static boolean isAnagram(String s, String t) {
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < s.length(); i++)
        {
        	list.add(s.charAt(i)+"");
        }
        for(int j = 0; j < t.length(); j++)
        {
        	String temp = t.charAt(j)+"";
        	if(list.contains(temp))
        	{
        		list.remove(temp);
        	}
        	else
        	{
        		return false;
        	}
        }
        if(list.isEmpty())
        {
        	return true;        	
        }
        return false;
    }
}
