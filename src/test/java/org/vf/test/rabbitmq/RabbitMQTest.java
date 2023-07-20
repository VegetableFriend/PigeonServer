package org.vf.test.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.nio.charset.StandardCharsets;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RabbitMQTestConfig.class})
public class RabbitMQTest {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    ReceiveInstance receiveInstance;

    @Test
    public void sendMessage() {
        final Message message;
        message = MessageBuilder
                .withBody("aabb".getBytes(StandardCharsets.UTF_8)).build();

        this.rabbitTemplate.send("ex.anno.fanout", "key.anno", message);
        this.receiveInstance.receiveMessage();
    }
}
