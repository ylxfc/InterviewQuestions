package com.yuli.mianshi;

import java.util.HashMap;
import java.util.Map;
/*
 * 求兄弟字符串
 */
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "adaa";
		String s2 = "daaa";
		System.out.println(BrotherString(s1, s2));
	}
	
	public static boolean BrotherString(String s1, String s2) {
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		Map<Character, Integer> m2 = new HashMap<Character, Integer>();
		for(int i=0;i<s1.length();i++) {
			Integer n = m.get(s1.charAt(i));
			m.put(s1.charAt(i), n == null ? 1 : n+1);
		}
		for(int i=0;i<s2.length();i++) {
			Integer n = m2.get(s2.charAt(i));
			m2.put(s2.charAt(i), n == null ? 1 : n+1);
		}
		if(m.equals(m2)) {
			return true;
		}else {
			return false;
		}
	}

}
