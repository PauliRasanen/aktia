package com.aktia.supportingclasses;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
 
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

//Java Message Service 2.0
public class JMS2 {
	
	//Lisää viestin "messageQueue" jonoon
	public static void messageQueue(String message) throws URISyntaxException, Exception {
		BrokerService broker = BrokerFactory.createBroker(new URI(
                "broker:(tcp://localhost:61616)"));
        broker.start();
        Connection connection = null;
        try {
            // Producer
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue("messageQueue2");
            Message msg = session.createTextMessage(LocalDateTime.now()+ " : " +message);
            MessageProducer producer = session.createProducer(queue);
            System.out.println("Sending text '" + LocalDateTime.now()+ " : " +message + "'");
            producer.send(msg);
 
        } finally {
            if (connection != null) {
                connection.close();
            }
                        broker.stop();
        }
	}
	
	//Katsoo viestit "messageQueue" jonosta
	public static void browseQueue() throws URISyntaxException, Exception {
		BrokerService broker = BrokerFactory.createBroker(new URI(
                "broker:(tcp://localhost:61616)"));
        broker.start();
        Connection connection = null;
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                    "tcp://localhost:61616");
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue("messageQueue2");
            connection.start();
             
            System.out.println("Browse through the elements in queue");
            QueueBrowser browser = session.createBrowser(queue);
            Enumeration e = browser.getEnumeration();
            while (e.hasMoreElements()) {
                TextMessage message = (TextMessage) e.nextElement();
                System.out.println("Get [" + message.getText() + "]");
            }
            System.out.println("Done");
            browser.close();
        } finally {
            if (connection != null) {
                connection.close();
            }
            broker.stop();
        }
	}
}
