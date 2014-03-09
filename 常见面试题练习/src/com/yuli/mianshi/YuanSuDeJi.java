package com.yuli.mianshi;

public class YuanSuDeJi {
	/*
	 * a[0]变为a[1]到a[n-1]的积，a[1]变为a[0]和a[2]到a[n-1]的积，
	 * ……a[n-1]为a[0]到a[n-2]的积。
	 * 要求：具有线性复杂度。不能使用除法运算符。”
	 */

	public static void suanfa(int[] s) {
		int length = s.length;
		int[] prod_fore = new int[length];
		int[] prod_back = new int[length];
		
		prod_fore[0] = 1;
		prod_back[length-1] = 1;
		
		for(int i=1;i<length;++i) {
			prod_fore[i] = s[i-1] * prod_fore[i-1];
		}
		for(int i=length-2;i>=0;--i) {
			prod_back[i] = s[i+1] * prod_back[i+1];
		}
		for(int i=0;i<length;++i) {
			s[i] = prod_fore[i] * prod_back[i];
			System.out.println(s[i]);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = new int[] {1,1,1};
		suanfa(s);
	}

}
