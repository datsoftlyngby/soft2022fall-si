package dk.dd.p3eipcamel.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RabbitRouter extends RouteBuilder
{
    @Override
    public void configure() throws Exception
    {
        /*
        from("timer:hello?period=1000")
                .transform(simple("Random number ${random(0,100)}"))
                .to("rabbitmq:fan-exchange");
        */
        //from("timer:foo").to("log:bar");
        from("direct:foo")
                .to("rabbitmq:boo");
        from("rabbitmq:boo")
                .log("From RabbitMQ: ${body}");
    }


}
