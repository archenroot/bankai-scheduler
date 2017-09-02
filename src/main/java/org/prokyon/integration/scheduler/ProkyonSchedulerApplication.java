package org.prokyon.integration.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ConfigurationProperties

@ImportResource({ "classpath:dao-context.xml" })
public class ProkyonSchedulerApplication {
    public static void main(String[] args) {

        SpringApplication.run(ProkyonSchedulerApplication.class, args);
    }
}