package dk.dd.p3eipcamel.config;

import org.apache.camel.builder.RouteBuilder;

public class ContentBasedFileRouter extends RouteBuilder
{
    private static final String SOURCE_FOLDER = "src/data/indata";
    private static final String DESTINATION_FOLDER_TXT = "src/data/out-txt";
    private static final String DESTINATION_FOLDER_OTHER = "src/data/out-other";

    @Override
    public void configure() throws Exception
    {
        from("file://" + SOURCE_FOLDER + "?delete=false")
                .choice()
                    .when(simple("${file:ext} == 'txt'"))
                        .to("file://" + DESTINATION_FOLDER_TXT).
                    otherwise().to("file://" + DESTINATION_FOLDER_OTHER);
    }

}
