package com.gmaslowski.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;
import static org.joda.time.DateTime.now;

@Stateless
@Path("/mdb")
public class QueueController {

    private static final Logger log = LoggerFactory.getLogger(QueueController.class);

    @Resource(name = "MyJmsConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(name = "CustomTopic")
    private Topic topic;

    @Resource(name = "CustomQueue")
    private Queue queue;

    @POST
    @Path("/topic")
    public String topic(String amount) {

        try {
            Connection conn = connectionFactory.createConnection();
            Session ses = conn.createSession(false, AUTO_ACKNOWLEDGE);
            MessageProducer producer = ses.createProducer(topic);

            for (int i = 0; i < Integer.valueOf(amount); i++) {
                TextMessage yeah = ses.createTextMessage();
                yeah.setText(now().toString());
                producer.send(yeah);
                log.info("publishing to topic");
            }

            conn.close();
        } catch (JMSException e) {
            log.warn(e.getMessage());
        }

        return "OK";
    }

    @POST
    @Path("/queue")
    public String queue(String amount) {

        try {
            Connection conn = connectionFactory.createConnection();
            Session ses = conn.createSession(false, AUTO_ACKNOWLEDGE);
            MessageProducer producer = ses.createProducer(queue);

            for (int i = 0; i < Integer.valueOf(amount); i++) {
                TextMessage yeah = ses.createTextMessage();
                yeah.setText(now().toString());
                producer.send(yeah);
                log.info("publishing to queue");
            }

            conn.close();
        } catch (JMSException e) {
            log.warn(e.getMessage());
        }

        return "OK";
    }
}
