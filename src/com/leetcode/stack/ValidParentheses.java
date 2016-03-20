package com.leetcode.stack;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  s = "(){}[({})](";
		System.out.println(isValid(s));
	}

	/*����:����һ���ַ����������������ַ� '(', ')', '{', '}', '[' and ']',
	 * Ҫ���ж�����ַ�������Ч�ԡ���Ч:"()" and "()[]{}" "[()]"
	 * ��Ч:"(]" and "([)]"
	 * ˼·��
	 * ��һ��ջ������Щ�ַ������Ϸ��Ļ�������ջ�����Ϸ���ֱ��return ����
	 * �Ϸ����ж��ǣ�������Ϊ ')','}',']'��ʱ���ж�ջ����Ԫ���ǲ�����֮��Ӧ�ģ�
	 * �ǵĻ��������ұ߷��� ͬʱ��ջ�����������ַ�����
	 * ���ַ��������꣬ջҲΪ�յ�ʱ�򣬾��ǺϷ���.
	 * */
	 public static boolean isValid(String s) {
	     Stack<Character> stack = new Stack<Character>();
		 for(char c: s.toCharArray())
	     {
	    	 if(stack.isEmpty())
	    	 {
	    		 stack.push(c);
	    	 }
	    	 else
	    	 {
	    		 char ch = stack.peek();
	    		 int result = isMatch(c, ch);
	    		 switch(result)
	    		 {
	    		 case 0:
	    			 stack.push(c);
	    			 break;
	    		 case 1:
	    			 stack.pop();
	    			 break;
	    		 case -1:
	    			 return false;
	    		 }
	    	 } 
	    		
	     }
		 if(stack.isEmpty())
		 {
			 return  true;			 
		 }
		 return false;
	 }
	 
	 public static int isMatch(char c,char d)
	 {
		 switch(c)
		 {
		 case '(':
		 case '{':
		 case '[':
			 return 0; 
		 case ')':
			 if(d == '(')
			 {
				 return 1;
			 }
			 break;
		 case '}':
			 if(d == '{')
			 {
				 return 1;
			 }
			 break;
		 case ']':
			 if(d == '[')
			 {
				 return 1;
			 }
			 break;
		default :
				 break;
		 }
		 return -1;
	 }
}
