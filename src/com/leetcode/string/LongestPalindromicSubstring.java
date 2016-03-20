package com.leetcode.string;

import com.sun.xml.internal.ws.util.StringUtils;

public class LongestPalindromicSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long begin = System.currentTimeMillis(); // 这段代码放在程序执行前

		System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		long end = System.currentTimeMillis() - begin; // 这段代码放在程序执行后
		System.out.println("耗时：" + end + "毫秒");
	}

	/*
		网上做法:
		复杂度:
	 */
	public static String longestPalindrome(String s) {
	    char[] str=s.toCharArray();
	    int max=1;//record max length of palindrome
	    int cur=1;
	    int front,next;
	    int count;//record temp max length of palindrome
	    int index=0;//record longest palindrome beginning location 
	    if(str.length==2&&str[0]==str[1]) return s;
	    while(cur<str.length-1&&(str.length-cur-1)*2>max){//handle length of string greater than three
	        front=cur-1;
	        next=cur+1;
	        count=1;
	        if(str[front]==str[cur]||str[next]==str[cur]){//judge is there has continuous char and count them
	            while(front>=0){
	                if(str[front]==str[cur]){
	                    count++;
	                    front--;
	                }
	                else break;
	            }
	            while(next<=str.length-1){
	                if(str[next]==str[cur]){
	                    count++;
	                    next++;
	                }
	                else break;
	            }
	           cur=next;//reset cur location
	           while(front>=0&&next<=str.length-1){// judge is there has palindrome like 'cbaaaaaabc'
	               if(str[front]==str[next]){
	                   count=count+2;
	                   front--;
	                   next++;
	               }
	               else break;
	           }
	           if(count>max){
	              max=count;
	              index=front+1;// reset beginning location of longest  palindrome
	           }
	      }
	      else{// count palindrome taking 'cur' location as center
	          while(front>=0&&next<=str.length-1){
	              if(str[front]==str[next]){
	                  count=count+2;
	                  front--;
	                  next++;
	              }
	              else break;
	          }
	          cur++;
	          if(count>max){
	              max=count;
	              index=front+1;
	          }
	      }
	    }
	    return s.substring(index,index+max);
	}
	
	public static String Palindrome(String s)
	{
		if(s.isEmpty())
		{
			return s;
		}
		int max = 0; // 记录最长的回文字串
		String temp = "";//临时比较字符串
		String result = String.valueOf(s.charAt(0));
		
		int start = 0;
		
		while(start <=  s.length() - 1)
		{
			if(IsPalindrome(s.substring(start)))
			{
				if(max < s.substring(start).length())
				{
					max = s.substring(start).length();
					result = s.substring(start);
					break;
				}
				else
				{
					start++;
					continue;
				}
			}
			
			int end = start;
			while(s.substring(start).length() > max)
			{
				
				end = s.indexOf(String.valueOf(s.charAt(start)), end+1);
				if(end == -1)
				{
					break;
				}
				//核心代码
				temp = s.substring(start, end+1);
				
				if (temp.length() <= max) {
					continue;
				} 
				else if (IsPalindrome(temp)) {
						max = temp.length();
						result = temp;
				}
				
			}
			
			start++;
		}
		return result;
	}
	
	public static boolean IsPalindrome(String s)
	{
		for(int i = 0, j = s.length() -1; i <= j; i++, j--)
		{
			if(s.charAt(i) != s.charAt(j))
			{
				return false;
			}
		}
		return true;
	}

}
