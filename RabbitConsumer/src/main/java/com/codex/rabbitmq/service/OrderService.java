package com.codex.rabbitmq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codex.rabbitmq.dto.Order;
import com.codex.rabbitmq.receiver.RabbitConsumer;

@Service
public class OrderService {
	@Autowired
	private RabbitConsumer rabbitConsumer;
	
	public Order getOrder(){
		return rabbitConsumer.getOrder();
	}
}
