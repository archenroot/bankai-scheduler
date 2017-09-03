package org.prokyon.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class CronScheduler {
    private String cronExpression;
    private int misfireInstruction = 2;
}
