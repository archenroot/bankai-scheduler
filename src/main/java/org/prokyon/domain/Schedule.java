package org.prokyon.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class Schedule {
    private SimpleScheduler simpleScheduler;
    private CronScheduler cronSchedule;
    private Trigger trigger;
    private boolean simpleSchedule = true;
}
