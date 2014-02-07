package com.gmaslowski.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")},
        name = "CustomQueue")
public class CustomQueueListener implements MessageListener {

    private static final Logger log = LoggerFactory.getLogger(CustomQueueListener.class);

    private static int instanceNumber = 0;

    private int currentInstanceNumber;

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            log.info("instance: {}, says: {}", currentInstanceNumber, textMessage.getText());
        } catch (JMSException e) {
            log.warn("exception: ", e);
        }
    }
}
