package com.thinkgem.jeesite.modules.air.util;

import org.apache.commons.lang3.RandomUtils;

import com.thinkgem.jeesite.common.utils.DBUtil;
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
	

	public static TbAirQuality getCurrentAQ() {
		TbTempHum tempHum = DBUtil.queryTempHum();
		co2.setCo2(RandomUtils.nextInt(100, 300));
		pm25.setPm25(RandomUtils.nextInt(100, 200));
		/*//保留两位小数
		BigDecimal b1 = new BigDecimal(RandomUtils.nextFloat(25, 30));
		BigDecimal b2 = new BigDecimal(RandomUtils.nextFloat(25, 30));
		float f1 = b1.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		float f2 = b2.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();*/
		// b.setScale(2, BigDecimal.ROUND_HALF_UP)
		AQ.setCo2(co2);
		DBUtil.insertCO2(co2.getCo2()+"");
		AQ.setPm25(pm25);
		DBUtil.insertPM2_5(pm25.getPm25()+"");
		AQ.setTempHum(tempHum);
		return AQ;
	}
}
