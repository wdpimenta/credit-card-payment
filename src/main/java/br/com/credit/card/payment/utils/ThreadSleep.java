package br.com.credit.card.payment.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadSleep {
    private static final Logger logger = LoggerFactory.getLogger(ThreadSleep.class);

    public ThreadSleep() {
    }

    public static void ofSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            logger.error("Error: {}", e.getMessage());
        }
    }
}
