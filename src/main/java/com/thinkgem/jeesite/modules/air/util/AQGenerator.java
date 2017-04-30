package com.thinkgem.jeesite.modules.air.util;

import java.math.BigDecimal;

import org.apache.commons.lang3.RandomUtils;

import com.thinkgem.jeesite.modules.air.entity.TbAirQuality;
import com.thinkgem.jeesite.modules.air.entity.TbCO2;
import com.thinkgem.jeesite.modules.air.entity.TbPm25;
import com.thinkgem.jeesite.modules.air.entity.TbTempHum;

/**
 * 
 * @author Frank Wang 空气质量生成器，用于模拟监测到的数据
 *
 */
public class AQGenerator {
	private static TbAirQuality AQ = new TbAirQuality();
	private static TbCO2 co2 = new TbCO2();
	private static TbPm25 pm25 = new TbPm25();
	private static TbTempHum tempHum = new TbTempHum();

	public static TbAirQuality getCurrentAQ() {
		co2.setCo2(RandomUtils.nextInt(100, 300));
		pm25.setPm25(RandomUtils.nextInt(100, 200));
		//保留两位小数
		BigDecimal b1 = new BigDecimal(RandomUtils.nextFloat(25, 30));
		BigDecimal b2 = new BigDecimal(RandomUtils.nextFloat(25, 30));
		float f1 = b1.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		float f2 = b2.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		// b.setScale(2, BigDecimal.ROUND_HALF_UP)
		tempHum.setTemp(f1);
		tempHum.setHum(f2);
		AQ.setCo2(co2);
		AQ.setPm25(pm25);
		AQ.setTempHum(tempHum);

		return AQ;
	}
}
