package com.codex.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codex.rabbitmq.dto.Order;
import com.codex.rabbitmq.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping("/orders")
	public ResponseEntity<Order> receiveOrder() {
		return new ResponseEntity<>(orderService.getOrder(), HttpStatus.OK);
	}
}
