package dk.dd.rabbit5producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitCamelProducerApplication
{
     public static void main(String[] args)
        {
            String message = args[0];
        try
        {
            RabbitConfig rabbitConfig = new RabbitConfig();
            RabbitConfig.configConnection(message);
        }
         catch (Exception e)
            {
                e.printStackTrace();
            }
            SpringApplication.run(RabbitCamelProducerApplication.class, args);
        }

}

