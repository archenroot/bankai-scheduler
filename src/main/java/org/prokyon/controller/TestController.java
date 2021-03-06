package org.prokyon.controller;

import java.util.HashMap;
import java.util.Map;

import org.prokyon.configuration.QuartzScheduler;
import org.prokyon.util.PropertiesUtils;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.prokyon.quartz.jobs.DynamicJob;
import org.prokyon.util.AppUtil;

@RestController
public class TestController {
	
	@Value("${con.key2}")
	String conKey2;
	
	@Autowired
	private SchedulerFactoryBean schedFactory;
	
	@RequestMapping("/getval")
    public String getVal(@RequestParam(value="key", defaultValue="World") String key) {
		Map<String, String> mapOfKeyValue = new HashMap<String, String>();
		mapOfKeyValue.put(key, PropertiesUtils.getProperty(key));
		mapOfKeyValue.put("con.key2", conKey2);
		return AppUtil.getBeanToJsonString(mapOfKeyValue);
    }
	
	@RequestMapping("/schedule")
	public String schedule() {
		String scheduled = "Job is Scheduled!!";
		try {
			JobDetailFactoryBean jdfb = QuartzScheduler.createJobDetail(DynamicJob.class);
			jdfb.setBeanName("dynamicJobBean");
			jdfb.afterPropertiesSet();
			
			SimpleTriggerFactoryBean stfb = QuartzScheduler.createTrigger(jdfb.getObject(),5000L);
			stfb.setBeanName("dynamicJobBeanTrigger");
			stfb.afterPropertiesSet();
			
			schedFactory.getScheduler().scheduleJob(jdfb.getObject(), stfb.getObject());
			
		} catch (Exception e) {
			scheduled = "Could not schedule a job. " + e.getMessage();
		}
		return scheduled;
	}
	
	@RequestMapping("/unschedule")
	public String unschedule() {
		String scheduled = "Job is Unscheduled!!";
		TriggerKey tkey = new TriggerKey("dynamicJobBeanTrigger");
		JobKey jkey = new JobKey("dynamicJobBean"); 
		try {
			schedFactory.getScheduler().unscheduleJob(tkey);
			schedFactory.getScheduler().deleteJob(jkey);
		} catch (SchedulerException e) {
			scheduled = "Error while unscheduling " + e.getMessage();
		}
		return scheduled;
	}
}