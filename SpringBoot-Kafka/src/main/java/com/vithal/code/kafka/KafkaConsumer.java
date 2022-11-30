package com.vithal.code.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	private Logger log=LoggerFactory.getLogger(KafkaConsumer.class);
	@KafkaListener(topics = "vithal", groupId = "myGroup")
	public void consume(String message) {
		
		log.info(String.format("MESSAGE RECIVED %S", message));
		
	}

}
