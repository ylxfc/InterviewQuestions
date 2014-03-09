package com.yuli.mianshi;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

class Producer extends Thread{

	private BlockingQueue<String> bg;
	public Producer(BlockingQueue<String> bg) {
		this.bg = bg;
	}
	
	public void run() {
		String[] strArr = new String[]
				{
				"1",
				"2",
				"3"
				};
		for(int i=0;i<999999999;i++) {
			System.out.println(Thread.currentThread().getName() + "生产者准备生产的集合元素！");
			try{
				Thread.sleep(200);
				//尝试放入元素，如果队列已满，则线程被阻塞
				bg.put(strArr[i%3]);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "生产完成：" + bg);
		}
	}
}

class Consumer extends Thread {
	private BlockingQueue<String> bg;
	public Consumer(BlockingQueue<String> bg) {
		this.bg = bg;
	}
	public void run() {
		while(true) {
			System.out.println(getName() + "消费者准备消费集合元素!");
			try {
				Thread.sleep(200);
				//尝试取出元素，如果队列已空，则线程被阻塞
				bg.take();
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println(getName()+ "消费完成：" + bg);
		}
	}
}

public class BlockingQueueTest {
	public static void main(String[] args) {
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
		
		new Producer(bq).start();
		new Producer(bq).start();
		new Producer(bq).start();
		
		new Consumer(bq).start();
		
	}
}
