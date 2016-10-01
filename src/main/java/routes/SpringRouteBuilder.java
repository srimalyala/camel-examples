package routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by srikanth on 2016/09/25.
 */
public class SpringRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:/Users/srikanth/in?noop=true").to("jms:incoming");
    }
}
