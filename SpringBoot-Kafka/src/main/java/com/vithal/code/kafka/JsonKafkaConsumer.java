package com.vithal.code.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.vithal.code.kafka.payload.User;

@Service
public class JsonKafkaConsumer {

	private Logger log=LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	
	@KafkaListener(topics = "vikki",groupId = "myGroup")
	public void consume(User user) {
		log.info(String.format(" JSON message recived %s", user.toString()));
		
		
	}
}
