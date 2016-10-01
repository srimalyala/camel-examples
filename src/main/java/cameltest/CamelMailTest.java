package cameltest;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by srikanth on 2016/10/01.
 */
public class CamelMailTest {

    public static void main(String args[]) throws Exception {
        final CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:/Users/srikanth/in?noop=true").
                        setHeader("subject", simple("New application")).
                        log("Sending meil ").
                        to("smtps://smtp.gmail.com" +
                                "?username=s****mala@gmail.com&" +
                                "password=*****&to=personalirs@mail.com");
            }
        });
        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}
