package com.thinkgem.jeesite.modules.sys.listener;

import java.util.Timer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.web.context.WebApplicationContext;

import com.thinkgem.jeesite.modules.sys.service.SystemService;

public class WebContextListener extends org.springframework.web.context.ContextLoaderListener {
	//private Timer timer = null; 
	@Override
	public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
       /* timer = new Timer(true);   
        servletContext.log("定时器已启动...");
        timer.schedule(new SaveAQTast(servletContext), 1000*30, 1000*60);
        servletContext.log("已经添加任务调度表...");*/
		
		if (!SystemService.printKeyLoadMessage()){
			return null;
		}
		return super.initWebApplicationContext(servletContext);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
	}
	
}
