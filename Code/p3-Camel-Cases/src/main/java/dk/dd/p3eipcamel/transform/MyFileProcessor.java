package dk.dd.p3eipcamel.transform;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class MyFileProcessor implements Processor
{
      public void process(Exchange ex) throws Exception
      {
            String iget = (String)ex.getIn().getBody(String.class);
            StringBuilder sign = new StringBuilder();
            sign.append("tdi");
            ex.getIn(). setBody(iget + sign.toString());
      }
}
