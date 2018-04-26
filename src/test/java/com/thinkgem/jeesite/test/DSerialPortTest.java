package com.thinkgem.jeesite.test;

import org.junit.Test;

import com.thinkgem.jeesite.common.utils.DSerialPort;

public class DSerialPortTest {

	@Test
	public void testTempAndHum() {
		
		
		DSerialPort serialPort=new DSerialPort();
		serialPort.listPort();
		serialPort.selectPort("COM2");
		serialPort.startRead(300);
		
		Thread t1=new Thread(serialPort);
		t1.run();
		
	}

}
