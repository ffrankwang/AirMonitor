package me.frank.thread.test;
/**
 * 线程间通信，子线程运行5次，主线程运行10次，交替往复运行。
 * @author Frank Wang
 *
 */
public class TraditionaThreadCommunication {

	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					business.sub(i);
				}
			}
		}).start();

		for (int i = 0; i < 10; i++) {
			business.main(i);
		}
	}

}

class Business {
	boolean bShouldSub = true;

	public synchronized void sub(int no) {
		if(!bShouldSub){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			for (int i = 0; i < 5; i++) {
				System.out.println("Sub Thread:" + no + " of " + i);
			}
			bShouldSub=!bShouldSub;
			this.notify();
		
	}

	public synchronized void main(int no) {
		if(bShouldSub){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread:" + no + " of " + i);
		}
		bShouldSub=!bShouldSub;
		this.notify();
	}
}
