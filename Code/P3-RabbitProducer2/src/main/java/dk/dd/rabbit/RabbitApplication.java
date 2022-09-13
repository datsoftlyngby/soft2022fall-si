package dk.dd.rabbit;
/*
 * Fanout Producer
 * Produces messages for everyone online that listens to the same exchange
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
    private final static String EXCHANGE_NAME = "fanout-exchange";

    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(RabbitApplication.class, args);
        
        String message = args.length < 1 ? "Hello World!" : String.join(" ", args);
        createQueue(message);
        System.out.println("Producer 2 sent '" + message + "'");
    }

    public static void createQueue(String message) throws Exception
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            // channel.queueDeclare(queueName, false, false, false, null);
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
        }
    }
}
