package org.prokyon.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(fluent = true)
public class Trigger {
    private Date startDate;
    private Date endDate;
    private String name;
    private String group;
}
