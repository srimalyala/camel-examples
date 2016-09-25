package cameltest;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by srikanth on 2016/09/25.
 */
public class SpringCamelTest {
    public static void main(String args[]) throws Exception {
        final ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext(
                "spring-context.xml");

        final CamelContext camelContext = SpringCamelContext.springCamelContext(
                appContext, false);

        camelContext.start();
        Thread.sleep(10000);
        camelContext.stop();

    }
}
