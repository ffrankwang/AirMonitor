package com.thinkgem.jeesite.modules.air.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomUtils;

import com.google.common.collect.Maps;
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

	public static Map<String, Object> getCurrentAQ() {
		/*
		 * TbTempHum tempHum = DBUtil.queryTempHum();
		 * co2.setCo2(RandomUtils.nextInt(100, 300));
		 * pm25.setPm25(RandomUtils.nextInt(100, 200)); //保留两位小数 BigDecimal b1 =
		 * new BigDecimal(RandomUtils.nextFloat(25, 30)); BigDecimal b2 = new
		 * BigDecimal(RandomUtils.nextFloat(25, 30)); float f1 = b1.setScale(2,
		 * BigDecimal.ROUND_HALF_UP).floatValue(); float f2 = b2.setScale(2,
		 * BigDecimal.ROUND_HALF_UP).floatValue(); // b.setScale(2,
		 * BigDecimal.ROUND_HALF_UP) AQ.setCo2(co2);
		 * DBUtil.insertCO2(co2.getCo2()+""); AQ.setPm25(pm25);
		 * DBUtil.insertPM2_5(pm25.getPm25()+""); AQ.setTempHum(tempHum);
		 */
		// 保留两位小数
		BigDecimal b1 = new BigDecimal(RandomUtils.nextFloat(4, 11)/100);
		BigDecimal b2 = new BigDecimal(RandomUtils.nextFloat(2, 6)/10);
		BigDecimal b3 = new BigDecimal(RandomUtils.nextFloat(0, 1)/10);
		BigDecimal b4 = new BigDecimal(RandomUtils.nextFloat(22, 28));
		BigDecimal b5 = new BigDecimal(RandomUtils.nextFloat(40, 80));
		BigDecimal b6 = new BigDecimal(RandomUtils.nextFloat(3, 15)/100);
		Float f1 = b1.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		Float f2 = b2.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		Float f3 = b3.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		Float f4 = b4.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		Float f5 = b5.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		Float f6 = b6.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		HashMap<String, Object> map = Maps.newHashMap();
		Float CO2 = f1;
		Float SO2 = f2;
		Float HCHO = f3;
		Float temp = f4;
		Float hum = f5;
		Float PM10 = f6;

		map.put("CO2", CO2);
		map.put("SO2", SO2);
		map.put("HCHO", HCHO);
		map.put("temp", temp);
		map.put("hum", hum);
		map.put("PM10", PM10);
		return map;
	}
}
