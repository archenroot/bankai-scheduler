/**
 * 
 */
package org.prokyon.quartz.jobs;

import org.prokyon.configuration.QuartzScheduler;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Component;

import org.prokyon.util.AppLogger;

/**
 * @author zangetsu
 *
 */
@Component
//@DisallowConcurrentExecution
public class JobWithSimpleTrigger implements Job {

	private final static AppLogger logger = AppLogger.getInstance();
	
	@Value("${cron.frequency.jobwithsimpletrigger}")
    private long frequency;

	@Override
	public void execute(JobExecutionContext jobExecutionContext) {
		logger.info("Running JobWithSimpleTrigger | frequency {}", frequency);
	}
	
	@Bean(name = "jobWithSimpleTriggerBean")
    public JobDetailFactoryBean sampleJob() {
        return QuartzScheduler.createJobDetail(this.getClass());
    }

    @Bean(name = "jobWithSimpleTriggerBeanTrigger")
    public SimpleTriggerFactoryBean sampleJobTrigger(@Qualifier("jobWithSimpleTriggerBean") JobDetail jobDetail) {
    	return QuartzScheduler.createTrigger(jobDetail,frequency);
    }
}
