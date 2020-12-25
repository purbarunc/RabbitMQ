package com.codex.rabbitmq.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codex.rabbitmq.dto.Order;
import com.codex.rabbitmq.publisher.RabbitSender;

@Service
public class OrderService {
	@Autowired
	private RabbitSender rabbitSender;
	public String pushOrdertoWaitingQueue(Order order) {
		order.setOrderId(UUID.randomUUID().toString());
		rabbitSender.pushMessage(order);
		return order.getOrderId();
	}
}
