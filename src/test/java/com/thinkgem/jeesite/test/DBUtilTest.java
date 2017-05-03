package com.thinkgem.jeesite.test;

import org.junit.Test;

import com.thinkgem.jeesite.common.utils.DBUtil;
import com.thinkgem.jeesite.modules.air.entity.TbTempHum;

public class DBUtilTest {
	@Test
	public void testQueryTempHum() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TbTempHum queryTempHum = DBUtil.queryTempHum();
			System.out.println("当前温度：" + queryTempHum.getTemp() + "当前湿度：" + queryTempHum.getHum());
		}
	}
}
