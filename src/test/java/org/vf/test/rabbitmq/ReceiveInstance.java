package org.vf.test.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceiveInstance {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void receiveMessage() {
        Message message = this.rabbitTemplate.receive("queue.anno");

        System.out.println(message);
    }
}
