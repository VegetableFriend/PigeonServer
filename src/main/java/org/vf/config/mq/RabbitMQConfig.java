package org.vf.config.mq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
@Configuration
public class RabbitMQConfig {

    @Bean
    ConnectionFactory connectionFactory() {
        ConnectionFactory connectionFactory = new CachingConnectionFactory(URI.create("amqp://guest:guest@127.0.0.1:5672"));

        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(@Autowired ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory factory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(factory);
        return rabbitAdmin;
    }

    // Queue
    @Bean
    public Queue queue() {
        final Queue queue = QueueBuilder.nonDurable("queue.anno").build();
        return queue;
    }

    // Exchange
    @Bean
    public Exchange exchange() {
        final FanoutExchange fanoutExchange = new FanoutExchange("ex.anno.fanout", false, false, null);
        return fanoutExchange;
    }

    // Binding
    @Bean
    @Autowired
    public Binding binding(Queue queue, Exchange exchange) {
        final Binding binding = BindingBuilder.bind(queue).to(exchange).with("key.anno").noargs();
        return binding;
    }
}
