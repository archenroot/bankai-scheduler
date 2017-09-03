package org.prokyon.amqp;

import javax.jms.Queue;

import org.prokyon.util.AppLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class SampleProducer implements CommandLineRunner {

    private final static AppLogger logger = AppLogger.getInstance();

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Override
    public void run(String... args) throws Exception {
        send("===== TESTING MESSAGE =====");
        logger.info("Message was sent to the Queue");
    }

    public void send(String msg) {
        logger.info("Queue send void invocated.");
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

}