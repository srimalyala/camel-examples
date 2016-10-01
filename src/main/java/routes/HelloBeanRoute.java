package routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by srikanth on 2016/09/27.
 */
public class HelloBeanRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/Users/srikanth/in?noop=true").to("bean:helloBean");
    }
}
