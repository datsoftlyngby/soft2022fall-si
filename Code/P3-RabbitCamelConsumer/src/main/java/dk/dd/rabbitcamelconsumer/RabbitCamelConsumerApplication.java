package dk.dd.rabbitcamelconsumer;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitCamelConsumerApplication
{
      public static void main(String[] args)
      {
            CamelContext myContext = new DefaultCamelContext();
            CamelRoute myRoute = new CamelRoute();
            // ContentSplitter routeBuilder = new ContentSplitter();
            // ContentTransform routeBuilder = new ContentTransform();
            
            try
            {
                  myContext.addRoutes(myRoute);
                  myContext.start();
                  Endpoint endpoint = myContext.getEndpoint("rabbitmq://localhost:5672/myrabbitexchange?username=guest&password=guest&autoDelete=false&routingKey=camel&queue=myrabbitqueue");
                  
                  Thread.sleep(1000);
                  myContext.stop();
            }
            catch (Exception e)
            {
                  e.printStackTrace();
            }
            SpringApplication.run(RabbitCamelConsumerApplication.class, args);
      }
}

