package cameltest;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

/**
 * Created by srikanth on 2016/09/20.
 */
public class CamelTest {
    public static void main(String args[]) throws Exception {
        final CamelContext context = new DefaultCamelContext();

        final ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.56.4:61616");
        context.addComponent("jms",
                JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("file:/Users/srikanth/in?noop=true").to("jms:incoming");
            }
        });

        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}
