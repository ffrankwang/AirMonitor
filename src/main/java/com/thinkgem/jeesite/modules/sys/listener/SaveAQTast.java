package com.thinkgem.jeesite.modules.sys.listener;

import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.thinkgem.jeesite.modules.air.entity.TbAirQuality;
import com.thinkgem.jeesite.modules.air.service.TbAirQualityService;
import com.thinkgem.jeesite.modules.air.service.TbCO2Service;
import com.thinkgem.jeesite.modules.air.service.TbPm25Service;
import com.thinkgem.jeesite.modules.air.service.TbTempHumService;
import com.thinkgem.jeesite.modules.air.util.AQGenerator;
public class SaveAQTast extends TimerTask {
	private TbCO2Service co2Service=new TbCO2Service();
	private TbPm25Service pm25Service=new TbPm25Service();
	private TbTempHumService tempHumService=new TbTempHumService();
	//private static final int C_SCHEDULE_HOUR = 0;
	private static boolean isRunning = false;
	private ServletContext context = null;
	@Autowired
	private TbAirQualityService tbAirQualityService=new TbAirQualityService();

	public SaveAQTast(ServletContext context) {
		this.context = context;
	}

	public void run() {
		//Calendar c = Calendar.getInstance();
		if (!isRunning) {
			isRunning = true;
			context.log("开始查询空气质量");
			TbAirQuality currentAQ = AQGenerator.getCurrentAQ();
			co2Service.save(currentAQ.getCo2());
			pm25Service.save(currentAQ.getPm25());
			tempHumService.save(currentAQ.getTempHum());
			context.log("当前空气质量为："+currentAQ);
			tbAirQualityService.save(currentAQ);
			isRunning = false;
			context.log("查询结束并记录到数据库");
		} else {
			context.log("上一次任务执行还未结束");
		}
	}

}
