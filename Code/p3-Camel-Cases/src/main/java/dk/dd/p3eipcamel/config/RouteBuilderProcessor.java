package dk.dd.p3eipcamel.config;

import dk.dd.p3eipcamel.transform.FileProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import dk.dd.p3eipcamel.transform.MyFileProcessor;

@Component
public class RouteBuilderProcessor extends RouteBuilder
{
      private static final String SOURCE_FOLDER = "src/data/indata";
      private static final String DESTINATION_FOLDER = "src/data/outdata";
      
      @Override
      public void configure() throws Exception
      {
            from("file://" + SOURCE_FOLDER + "?delete=false")
            // from("direct:in")
            .process(new MyFileProcessor())
            .to("file://" + DESTINATION_FOLDER);
      }
}
