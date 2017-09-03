package org.prokyon;

import org.apache.activemq.command.ActiveMQQueue;
import org.prokyon.util.AppLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import javax.jms.Queue;

@SpringBootApplication
//@ConfigurationProperties
@ImportResource({ "classpath:dao-context.xml" })
public class BankaiSchedulerApplication {
    private final static AppLogger logger = AppLogger.getInstance();

    @Bean
    public Queue queue() {
        logger.info("New queue sample.queue created");
        return new ActiveMQQueue("sample.queue");
    }


    public static void main(String[] args) {

        SpringApplication.run(BankaiSchedulerApplication.class, args);
    }
}