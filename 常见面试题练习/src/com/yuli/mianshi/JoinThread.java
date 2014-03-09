package com.yuli.mianshi;

public class JoinThread implements Runnable{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i = 0;i<100;i++) {
			if(i == 20) {
				JoinThread jt = new JoinThread();
				new Thread(jt,"被Join的线程").start();
				
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

}
