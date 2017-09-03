/**
 * 
 */
package org.prokyon.quartz.jobs;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import org.prokyon.util.AppLogger;

/**
 * @author zangetsu
 *
 */
//@DisallowConcurrentExecution
public class DynamicJob  implements Job {
	
	private final static AppLogger logger = AppLogger.getInstance();
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("----- Running Dynamic Job With Simple Trigger ------");
	}

}
