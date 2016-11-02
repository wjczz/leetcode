package com.leetcode.math;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class HappyNumber {

	/**
	 * @param args
	 * �������ʵ���ѣ�һ��ʼ ��������ɸѡ������int ��Χ�ڵ����ֶ���¼�������ж���û��ѭ���������������е�ʱ����30ms ���ң�����һֱ��ʱ
	 * ��������룬����map�����¼ ���ֹ������֣��������ܾͿ���ˣ�����Ҫÿ�����ж�ȥnew һ�����õ�����
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     long begin = System.currentTimeMillis(); // ��δ�����ڳ���ִ��ǰ

			if(isHappy(693))
			{
				System.out.println(237 + "�� happy num");
			}
		     long end = System.currentTimeMillis() - begin; // ��δ�����ڳ���ִ�к�
		     System.out.println("��ʱ��" + end + "����");
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
