package com.vithal.code.kafka.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vithal.code.kafka.dto.Order;
import com.vithal.code.kafka.dto.OrderEvent;
import com.vithal.code.kafka.service.OrderProducer;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	private OrderProducer orderProducer;

	public OrderController(OrderProducer orderProducer) {
		
		this.orderProducer = orderProducer;
	}
	
	@PostMapping("/orders")
	public String placeOrder(@RequestBody Order order) {
		order.setOrderId(UUID.randomUUID().toString());
		
		OrderEvent event=new OrderEvent();
		
		event.setStatus("PENDING!!");
		event.setMessage("ORDER STATUS IS PENDING PROCESS..");
		event.setOrder(order);
		
		orderProducer.sendMessage(event);
		return "Order placed sucecessfully";
	}
	
}
