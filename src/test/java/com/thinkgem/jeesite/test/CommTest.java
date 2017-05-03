package com.thinkgem.jeesite.test;

import com.thinkgem.jeesite.tools.Comm;

public class CommTest {
	public static void main(String[] args) {
		Thread spcommThread = new Thread(new Comm());
		spcommThread.setName("Thread-MyThread");
		spcommThread.start();

	}
}
