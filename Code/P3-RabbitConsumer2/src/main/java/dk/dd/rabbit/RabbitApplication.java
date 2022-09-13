package dk.dd.rabbit;
/*
 * Fanout Consumer
 * One of many, which will consume all messages coming from a certain Exchange
 */

import com.rabbitmq.client.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class RabbitApplication
{
    private final static String EXCHANGE_NAME = "fanout-exchange";

    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(RabbitApplication.class, args);
        connectQueue();
    }

    public static void connectQueue() throws Exception
    {
        // Create connection
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        
        // Create channel
        Channel channel = connection.createChannel();

        // Register for an exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        
        // Get the automatically generated qname for this exchange
        String queueName = channel.queueDeclare().getQueue();
        
        // Bind the exchange to the queue
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println("Consumer 2 waiting for messages. To exit press CTRL+C");

        // Get notified, if a message for this receiver arrives
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("Consumer 2 received '" + message + "'");
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {});
    }
}

