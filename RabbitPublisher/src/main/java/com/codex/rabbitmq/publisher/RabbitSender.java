package com.codex.rabbitmq.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codex.rabbitmq.configuration.RabbitMQConfig;
import com.codex.rabbitmq.dto.Order;

@Component
public class RabbitSender {
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	public void pushMessage(Order order) {
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE,RabbitMQConfig.ROUTING_KEY,order);
		
	}
}
