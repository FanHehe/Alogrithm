import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {
    public static void main (String args[]) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setUsername("fanhehe");
        factory.setPassword("13889441200");

        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();

        String exchange = "amq.direct";
        channel.exchangeDeclare(exchange, "direct", true);

        String routingKey = "test";
        byte[] message = "hello world".getBytes();

        channel.basicPublish(exchange, routingKey, null, message);

        channel.close();
        conn.close();
    }
}
