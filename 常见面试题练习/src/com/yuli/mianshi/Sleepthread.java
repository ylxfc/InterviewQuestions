package com.yuli.mianshi;

import java.util.Date;

public class Sleepthread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		for(int i = 0;i<10;i++) {
			System.out.println(new Date());
			Thread.sleep(1000);
		}
	}

}
