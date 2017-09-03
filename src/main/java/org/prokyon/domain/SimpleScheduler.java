package org.prokyon.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class SimpleScheduler {
    private boolean repeatForever;
    private long interval;
    private int repeatCount;
    private int misfireInstruction = 4;
}
