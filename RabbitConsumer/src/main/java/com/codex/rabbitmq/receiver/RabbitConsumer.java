package com.codex.rabbitmq.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.codex.rabbitmq.configuration.RabbitMQConfig;
import com.codex.rabbitmq.dto.Order;

@Component
public class RabbitConsumer {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private Order order;

	@RabbitListener(queues = RabbitMQConfig.MYQUEUE)
	public void receiveOrdersFromQueue(Order order) {
		logger.info("Order Received-> {}", order);
		this.order=order;
	}

	public Order getOrder() {
		return order;
	}
}
