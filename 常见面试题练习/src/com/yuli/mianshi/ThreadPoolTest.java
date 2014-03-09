package com.yuli.mianshi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService pool = Executors.newFixedThreadPool(6);
		
		pool.submit(new MyThread());
		pool.submit(new MyThread());
		//关闭线程池
		pool.shutdown();
	}

}

class MyThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++) {
//			try {
//				Thread.currentThread().sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName() + "的i值为：" + i);
		}
		
	}
	
}