package com.codex.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codex.rabbitmq.dto.Order;
import com.codex.rabbitmq.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping("/order")
	public ResponseEntity<String> placeOrder(@RequestBody Order order) {
		String orderId = orderService.pushOrdertoWaitingQueue(order);
		String responseMeassge="Order Received with Order Id:"+orderId;
		return new ResponseEntity<>(responseMeassge, HttpStatus.OK);
	}
}
