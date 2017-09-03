package org.prokyon.amqp;

import org.prokyon.util.AppLogger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SampleConsumer {
    private final static AppLogger logger = AppLogger.getInstance();

    @JmsListener(destination = "sample.queue")
    public void receiveQueue(String text) {

        logger.info("Received message from queue: " + text);
    }
}
