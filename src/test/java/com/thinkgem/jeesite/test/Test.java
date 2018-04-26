package com.thinkgem.jeesite.test;

import com.thinkgem.jeesite.modules.air.util.AQGenerator;

public class Test {

	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			System.out.println(AQGenerator.getCurrentAQ().toString());
		}
	}
}
