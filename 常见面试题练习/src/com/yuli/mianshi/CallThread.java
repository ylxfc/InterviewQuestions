package com.yuli.mianshi;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallThread implements Callable<Integer>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CallThread ct = new CallThread();
		//使用futureTask来包装Callable对象
		FutureTask<Integer> task = new FutureTask<>(ct);
		for(int i = 0;i<100;i++) {
			System.out.println(Thread.currentThread().getName() + "的循环变量i的值:" + i);
			if(i == 20) {
//				try {
////					Thread.currentThread().sleep(100);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				new Thread(task, "有返回值的线程").start();
			}
		}
		try {
			System.out.println("子线程返回的值:" + task.get());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int i = 0;
		for(;i<100;i++) {
			System.out.println(Thread.currentThread().getName() + "的循环变量i的值：" + i);
		}
		return i;
	}

}
