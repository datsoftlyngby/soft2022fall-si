package dk.dd.rabbit;
/*
 * Topic Producer
 * Sends a message and keywords as a routingKey
 * Both the message and the topic keywords are entered as arguments of the application
 */

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitApplication
{
    // non-durable, exclusive, auto-delete queue with an automatically generated name
    private static String queueName = null;
    private final static String EXCHANGE_NAME = "topic-exchange";
    // routingKey is a composite topic of three words, concatenated with '.' given as args[1]
    private static String routingKey = "";
    private static String message = "Hello World!";

    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(RabbitApplication.class, args);
        
        // args[0]-message; args[1]-topics
        if (args.length > 0) message = args[0];
        if (args.length > 1) routingKey = args[1];

        createQueue(message, routingKey);
        System.out.println("Producer 4 sent key '" + routingKey + "' and message '" + message + "'");
    }

    public static void createQueue(String message, String rKey) throws Exception
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel())
            {
                // queueName = channel.queueDeclare().getQueue();
                channel.exchangeDeclare(EXCHANGE_NAME, "topic");

                // channel.queueDeclare(queueName, false, false, false, null);
                // bind Exchange to queue
                // channel.queueBind(queueName, EXCHANGE_NAME, "");
                channel.basicPublish(EXCHANGE_NAME, rKey, null, message.getBytes("UTF-8"));
            }
    }
}
