package com.yuli.mianshi;

import java.util.ArrayList;
import java.util.List;

public class Utest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<String>();
		l1.add("a");
		l1.add("b");
		l2.add("c");
		l2.add("b");
		for(String l: jiaoji(l1, l2)) {
			System.out.println(l);
		}
	}
	
	/*
	 * 求两个集合的交集
	 */
	public static List<String> jiaoji(List<String> l1, List<String> l2) {
		List<String> s1 = new ArrayList<String>();
		for(int i = 0;i<l1.size();i++) {
			if(l2.contains(l1.get(i)))
				s1.add(l1.get(i));
		}
		return s1;
	}
}
