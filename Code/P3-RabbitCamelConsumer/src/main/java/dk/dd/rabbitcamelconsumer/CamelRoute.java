package dk.dd.rabbitcamelconsumer;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.support.jndi.JndiContext;
import org.springframework.stereotype.Component;

@Component
public class CamelRoute extends RouteBuilder
{

        @Override
        public void configure() throws Exception
        {
            //MyTransformation mycase = new MyTransformation();
            //JndiContext jndiContext = new JndiContext();
            //jndiContext.bind("uppercase", new MyTransformation());


            from("rabbitmq:localhost:5672/myrabbitexchange?username=guest&password=guest&autoDelete=false&routingKey=camel&queue=myrabbitqueue")
                    .to("bean:dk.dd.rabbitcamelconsumer.MyTransformation")
                    .to("file:data/file")
                    .to("log:out:${body}");
        }
}



