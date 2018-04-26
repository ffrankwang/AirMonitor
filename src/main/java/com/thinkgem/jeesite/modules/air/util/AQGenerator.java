package com.thinkgem.jeesite.modules.air.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.thinkgem.jeesite.common.utils.DBUtil;
import com.thinkgem.jeesite.modules.air.entity.TbTempHum;
import org.apache.commons.lang3.RandomUtils;

import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.utils.DSerialPort;
import com.thinkgem.jeesite.modules.air.entity.TbAirQuality;

/**
 * 
 * @author Frank Wang 空气质量生成器，用于模拟监测到的数据
 *
 */
public class AQGenerator {
	private static TbAirQuality AQ = new TbAirQuality();
	// private static TbCO2 co2 = new TbCO2();
	// private static TbPm25 pm25 = new TbPm25();
	{
		DSerialPort serialPort=new DSerialPort();
		serialPort.listPort();
		serialPort.selectPort("COM3");
		serialPort.startRead(3000);
		
		Thread t1=new Thread(serialPort);
		t1.run();
	}
	public static Map<String, Object> getCurrentAQ() {

		 TbTempHum tempHum = DBUtil.queryTempHum();

		// 保留两位小数
		BigDecimal b1 = new BigDecimal(RandomUtils.nextFloat(4, 11)/100);
		BigDecimal b2 = new BigDecimal(RandomUtils.nextFloat(2, 6)/10);
		BigDecimal b3 = new BigDecimal(RandomUtils.nextFloat(0, 1)/10);

		BigDecimal b4 = new BigDecimal(tempHum.getTemp()==null?1:tempHum.getTemp());
		BigDecimal b5 = new BigDecimal(tempHum.getHum()==null?1:tempHum.getHum());

		BigDecimal b6 = new BigDecimal(RandomUtils.nextFloat(3, 15)/100);
		BigDecimal b7 = new BigDecimal(RandomUtils.nextFloat(3, 7));
		Float f1 = b1.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		Float f2 = b2.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		Float f3 = b3.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		Float f4 = b4.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		Float f5 = b5.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		Float f6 = b6.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		Float f7 = b7.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		HashMap<String, Object> map = Maps.newHashMap();
		Float CO2 = f1;
		Float SO2 = f2;
		Float HCHO = f3;
		Float temp = f4;
		Float hum = f5;
		Float PM10 = f6;
		Float CO=f7;

		map.put("CO2", CO2);
		map.put("SO2", SO2);
		map.put("HCHO", HCHO);
		map.put("temp", temp);
		map.put("hum", hum);
		map.put("PM10", PM10);
		map.put("CO", CO);
		return map;
	}
}
