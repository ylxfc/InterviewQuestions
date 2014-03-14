package com.yuli.mianshi;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account at = new Account("初始名");
		new MyTest(at, "线程甲").start();;
		new MyTest(at, "线程乙").start();;
	}

}
class Account {
	private ThreadLocal<String> name = new ThreadLocal<>();
	//定义一个构造器
	public Account(String str) {
		this.name.set(str);
		System.out.println("---"+ this.name.get());
	}
	public String getName() {
		return name.get();
	}
	public void setName(String str) {
		this.name.set(str);
	}
}
class MyTest extends Thread {
	private Account account;

	public MyTest(Account account, String name) {
		super(name);
		this.account = account;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
//			try {
//				Thread.currentThread().sleep(200);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			if(i==6) {
				account.setName(getName());
			}
			System.out.println(account.getName() + "账户的i值：" + i);
		}
	}
	
}
