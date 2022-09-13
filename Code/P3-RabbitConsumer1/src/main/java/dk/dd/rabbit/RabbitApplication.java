package dk.dd.rabbit;
/*
 * Message Consumer 1
 * 1- Creates a queue, if it is not yet created
 * 2- Registers for notification of messages sent to its ID
 */

import com.rabbitmq.client.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitApplication
{
    private final static String QUEUE_NAME = "midnightqueue";

    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(RabbitApplication.class, args);
        connectQueue();
    }

    public static void connectQueue() throws Exception
    {
        // AMQP (same as for the producer)
        // Create a connection object  for connection with the Rabbit server
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        
        // Open a channel for the connection
        Channel channel = connection.createChannel();

        // Create (declare) a queue, if not created
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println("Consumer 1 waiting for messages. To exit press CTRL+C");

        // Get notified, if a message for this consumer arrives
        DeliverCallback deliverCallback = (consumerTag, delivery) ->
        {
            String message = new String(delivery.getBody(), "UTF-8");
            Long tag = delivery.getEnvelope().getDeliveryTag();
            System.out.println("Consumer 1 received '" + message + "'" + " with delivery tag:" + tag);
        };
        // No notification handling at consuming
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
}
