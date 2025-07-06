import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
 
public class MainApp {
    public static void main(String[] args) throws Exception {
        var context = new DefaultCamelContext();
 
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
 
                // 1. Receive order from E-commerce
                from("undertow:http://0.0.0.0:8080/order")
                    .convertBodyTo(String.class)
                    .log("Order received: ${body}")
                    .setBody(simple("Order accepted"));
                // 2. Inventory update
                from("undertow:http://0.0.0.0:8080/inventory")
                    .convertBodyTo(String.class)
                    .log("Inventory update: ${body}")
                    .setBody(simple("Inventory updated"));
 
                // 3. Order status
                from("undertow:http://0.0.0.0:8080/order-status")
                    .convertBodyTo(String.class)
                    .log("Order status update: ${body}")
                    .setBody(simple("Order status updated"));
            }
        });
 
        context.start();
        System.out.println("EAI Middleware started...");
        Thread.sleep(Long.MAX_VALUE);
        context.stop();
    }
}
