package com.vithal.code.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.vithal.code.kafka.dto.OrderEvent;

@Service
public class EmailCOnsumer {
	
	private static final Logger log=LoggerFactory.getLogger(EmailCOnsumer.class);
	
	@KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent event) {
		
		log.info(String.format("order event recived in Email service ==>> %s", event.toString()));
		
		
		//save an email to the customer
		
	}
}
