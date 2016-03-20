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
	 * ����Ҫ��ƥ��2���ַ�����. 
	 * For example, 
	 * s = "anagram", t = "nagaram", return true. 
	 * s = "rat", t = "car", return false.
	 * ˼·:�ø�List��¼���˶��ٸ��ַ���Ȼ����ȥ����������ַ������ҵ�һ���ͼ���һ�� 
	 * ʱ�临�Ӷȶ�O(n+m) �ռ临�Ӷ�O(n)
	 * ����������
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
