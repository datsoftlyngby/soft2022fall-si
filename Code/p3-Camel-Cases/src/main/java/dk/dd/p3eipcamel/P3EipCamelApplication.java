package dk.dd.p3eipcamel;

import dk.dd.p3eipcamel.config.ContentBasedFileRouter;
import dk.dd.p3eipcamel.config.FileRouter;
import dk.dd.p3eipcamel.config.RouteBuilderProcessor;
import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class P3EipCamelApplication
{
      public static void main(String[] args) throws InterruptedException
      {
            // create camel, add routes, and start camel
            CamelContext ctx = new DefaultCamelContext();
            // RouteBuilderProcessor routeBuilder = new RouteBuilderProcessor();
            FileRouter routeBuilder = new FileRouter();
             // ContentBasedFileRouter routeBuilder = new ContentBasedFileRouter();
            try
            {
                  ctx.addRoutes(routeBuilder);
                  ctx.start();
                  Thread.sleep(3000);
                  ctx.stop();
            }
            catch (Exception e)
            {
                  e.printStackTrace();
            }
            SpringApplication.run(P3EipCamelApplication.class, args);
      }
      
}
