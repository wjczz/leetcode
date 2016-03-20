package com.leetcode;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c1 = 'A',c2;
		int i;
		i = c1 + 1;
		c2 = (char)i;
		String a = "a";
		System.out.println(c1 + a);
		System.out.println(c2);
		System.out.println((a+c1+c2));
		System.out.println(c1+a+c2+a);
		//char�洢����Unicode���룬char���ͽ���+-����Ļ���
		//����ֵ��int���͵�Unicode���룬��Ҫǿתһ��
		
		final char ch = 'm';
		System.out.println(ch);

		String str = "123";
		ChangeStr(str);
		System.out.println(str);
		
		short w = 1;
		w++;
		short ii = Short.valueOf("995");
		System.out.println(ii);
		ii = (short)(ii + 1);
		System.out.println(w);
		
		float aaa = 1.0f;
		int l = "asd".length();
		int k = 78;
		
		char cha = 10;
		System.out.println(cha+"1");
	}
	
	public static void ChangeStr(String str)
	{
		str = "welcome";
	}

}
