import com.rabbitmq.client.*;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main (String args[]) throws IOException, TimeoutException {
        ConnectionFactory factory =  new ConnectionFactory();

        factory.setHost("locahost");
        factory.setUsername("fanhehe");
        factory.setPassword("13889441200");

        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
        String exchange = "amq.direct";
        channel.exchangeDeclare(exchange, "direct", true);
        String queueName = channel.queueDeclare().getQueue();
        String routingKey = "test";
        channel.queueBind(queueName, exchange, routingKey);

        while (true) {
            boolean autoAck = false;
            String consumerTag = "";

            channel.basicConsume(queueName, autoAck, consumerTag, new DefaultConsumer(channel) {
               @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String routingKey = envelope.getRoutingKey();
                    String contentType = properties.getContentType();

                    System.out.println("comsume routingKey is " + routingKey);
                    System.out.println("consume body content is " + contentType);

                    long deliveryTag = envelope.getDeliveryTag();

                    channel.basicAck(deliveryTag, false);

                    System.out.println("the content is ");
                    String bodyStr = new String(body,"UTF-8");

                    System.out.println(bodyStr);
                }
            });
        }
    }
}
