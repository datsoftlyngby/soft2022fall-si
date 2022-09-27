package dk.dd.rabbitp;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class RabbitpApplication
{
      public static void main(String[] args) throws IOException, TimeoutException
      {
            String message = "Hey!";
            final var QUEUE_NAME = "first-rabbit";
            SpringApplication.run(RabbitpApplication.class, args);
      
            try
            {
                  ConnectionFactory factory = new ConnectionFactory();
                  factory.setHost("localhost");
                  Connection connection = factory.newConnection();
      
                  Channel channel = connection.createChannel();
      
                  channel.queueDeclare(QUEUE_NAME, false, false, false, null);
      
                  channel.basicPublish("", QUEUE_NAME, null, args[0].getBytes("UTF-8"));
            }
            catch(Exception e)
            {
                  System.out.println(e);
            }
      }
      
}
