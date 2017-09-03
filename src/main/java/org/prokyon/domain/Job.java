package org.prokyon.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

@Data
@Accessors(fluent = true)
public class Job {
    private String jobClass;
    private String name;
    private String group;
    private String description;
    private boolean storeDurably;
    private boolean requestRecovery;
    private Map<String, Object> jobParams;
}
