package me.frank.thread;

import org.junit.Test;

/**
 * 
 * @author Frank Wang
 *         <p>
 * 		传统线程同步测试类
 *         </p>
 *         线程不安全的例子
 */
public class TraditionalThreadSychronizedTest {
	@Test
	public void test() {
		new TraditionalThreadSychronizedTest().init();
	}

	public static void main(String[] args) {
		new TraditionalThreadSychronizedTest().init();
	}

	public void init() {
		Outputer outputer = new Outputer();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.output("Frank123456");
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.output("Bruce123456");
				}
			}
		}).start();
	}
/**
 * 临界资源
 * @author Frank Wang
 *
 */
	class Outputer {
		public synchronized void output(String msg) {
			int length = msg.length();
			{
				for (int i = 0; i < length; i++) {
					System.out.print(msg.charAt(i));
				}
				System.out.println();
			}
		}
	}

}
