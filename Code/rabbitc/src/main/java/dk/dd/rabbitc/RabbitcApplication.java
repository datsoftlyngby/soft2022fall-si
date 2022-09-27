package dk.dd.rabbitc;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitcApplication
{
      
      public static void main(String[] args)
      {
            final var QUEUE_NAME = "first-rabbit";
            SpringApplication.run(RabbitcApplication.class, args);
      
            try
            {
                  ConnectionFactory factory = new ConnectionFactory();
                  factory.setHost("localhost");
                  Connection connection = factory.newConnection();
            
                  Channel channel = connection.createChannel();
      
                  channel.queueDeclare(QUEUE_NAME, false, false, false, null);
      
                  // Get notified, if a message for this consumer arrives
                  DeliverCallback deliverCallback = (consumerTag, delivery) ->
                  {
                        String message = new String(delivery.getBody(), "UTF-8");
                        Long tag = delivery.getEnvelope().getDeliveryTag();
                        System.out.println("Consumer 1 received '" + message + "'" + " with delivery tag:" + tag);
                  };
                  // No notification handling at consuming
                  channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
                  });
      
            }
            catch (Exception e)
            {
                  System.out.println(e);
            }
      }
}
