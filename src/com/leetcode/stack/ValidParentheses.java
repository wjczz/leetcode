package com.leetcode.stack;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  s = "(){}[({})](";
		System.out.println(isValid(s));
	}

	/*需求:给你一串字符，仅仅包含以下字符 '(', ')', '{', '}', '[' and ']',
	 * 要求判断这个字符串的有效性。有效:"()" and "()[]{}" "[()]"
	 * 无效:"(]" and "([)]"
	 * 思路：
	 * 用一个栈保存这些字符，当合法的话，就入栈，不合法就直接return 函数
	 * 合法的判断是，当符号为 ')','}',']'的时候，判断栈顶的元素是不是与之对应的，
	 * 是的话，把这右边符号 同时出栈，继续遍历字符串。
	 * 当字符串遍历完，栈也为空的时候，就是合法的.
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
