package com.synisys.test.messaging.web.jmsclient;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class PortfolioJavaPersistenceClient implements MessageListener {
    private static int ackMode;
    private static String clientQueueName;

    static {
        clientQueueName = "portfolio.queue";
        ackMode = Session.AUTO_ACKNOWLEDGE;
    }

    private ArrayList<Map<String, Object>> maps;

    public PortfolioJavaPersistenceClient(Integer from, Integer to) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, ackMode);
            Destination adminQueue = session.createQueue(clientQueueName);

            //Setup a message producer to send message to the queue the server is consuming from
            MessageProducer producer = session.createProducer(adminQueue);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            //Create a temporary queue that this client will listen for responses on then create a consumer
            //that consumes message from this temporary queue...for a real application a client should reuse
            //the same temp queue for each message to the server...one temp queue per client
            Destination tempDest = session.createTemporaryQueue();
            MessageConsumer responseConsumer = session.createConsumer(tempDest);

            //This class will handle the messages to the temp queue as well
            responseConsumer.setMessageListener(this);

            //Now create the actual message you want to send
            Message message = session.createMessage();
            message.setIntProperty("from", from);
            message.setIntProperty("to", to);


            //Set the reply to field to the temp queue you created above, this is the queue the server
            //will respond to
            message.setJMSReplyTo(tempDest);

            //Set a correlation ID so when you get a response you know which sent message the response is for
            //If there is never more than one outstanding message to the server then the
            //same correlation ID can be used for all the messages...if there is more than one outstanding
            //message to the server you would presumably want to associate the correlation ID with this
            //message somehow...a Map works good
            String correlationId = this.createRandomString();
            message.setJMSCorrelationID(correlationId);
            producer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private String createRandomString() {
        return UUID.randomUUID().toString();
    }

    public void onMessage(Message message) {
        String messageText = null;
        if (message instanceof TextMessage) {
            ObjectMessage objectMessage = (ObjectMessage) message;
            try {
                maps = (ArrayList<Map<String, Object>>) objectMessage.getObject();
            } catch (JMSException e) {
                e.printStackTrace();
            }
            System.out.println("messageText = " + messageText);
        }
    }

    public ArrayList<Map<String, Object>> getMaps() {
        return maps;
    }
}