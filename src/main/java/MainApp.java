import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
 
public class MainApp {
    public static void main(String[] args) throws Exception {
        var context = new DefaultCamelContext();
 
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
 
                // 1. Receive order from E-commerce
from("jetty:http://0.0.0.0:8080/order")
                    .log("Order received: ${body}")
                    .to("log:order-processing");
 
                // 2. Inventory update
from("jetty:http://0.0.0.0:8080/inventory")
                    .log("Inventory update: ${body}")
                    .to("log:inventory-system");
 
                // 3. Order status
from("jetty:http://0.0.0.0:8080/order-status")
                    .log("Order status update: ${body}")
                    .to("log:order-status");
            }
        });
 
        context.start();
        System.out.println("EAI Middleware started...");
        Thread.sleep(99999999);
        context.stop();
    }
}