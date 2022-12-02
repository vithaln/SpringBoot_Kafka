package com.vithal.code.kafka.service;

import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.vithal.code.kafka.dto.OrderEvent;

@Service
public class OrderProducer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(OrderProducer.class);
	
	private NewTopic newTopic;
	
	private KafkaTemplate< String , OrderEvent> kafkaTemplate;

	public OrderProducer(NewTopic newTopic, KafkaTemplate<String, OrderEvent> kafkaTemplate) {
	
		this.newTopic = newTopic;
		this.kafkaTemplate = kafkaTemplate;
	}

	
	public void sendMessage(OrderEvent event) {
		
		LOGGER.info("order event {} ",event.toString());
		
		//create message
		Message<OrderEvent> message=MessageBuilder
				.withPayload(event)
				.setHeader(KafkaHeaders.TOPIC, newTopic.name()).build();
		kafkaTemplate.send(message);
	}
}
