package dk.dd.rabbit;
/*
 * Message Producer 1
 * Produces a simple message, which will be delivered to a specific consumer
 * 1 - Creates a queue
 * 2 - Sends the message to it
 */

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitApplication
{
    private final static String QUEUE_NAME = "midnightqueue";

    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(RabbitApplication.class, args);
        String message = "Good Night!";
        createQueue(message);
        System.out.println("Producer 1 sent '" + message + "'");
    }

    public static void createQueue(String message) throws Exception
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
            Channel channel = connection.createChannel())
            {
                channel.queueDeclare(QUEUE_NAME, false, false, false, null);
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            }
    }
}
