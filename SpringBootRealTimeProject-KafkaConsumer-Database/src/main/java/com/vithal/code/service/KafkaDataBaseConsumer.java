package com.vithal.code.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.vithal.code.entity.WikkiediaData;
import com.vithal.code.repository.WikkiRepo;

@Service
public class KafkaDataBaseConsumer {

	private static final Logger log=LoggerFactory.getLogger(KafkaDataBaseConsumer.class);
	private WikkiRepo wikirepo;
	
	public KafkaDataBaseConsumer(WikkiRepo wikirepo) {
	
		this.wikirepo = wikirepo;
	}

	@KafkaListener(topics = "wikimedia",groupId = "myGroup")
	public void consume(String eventMsg) {
		
		log.info(String.format("Message recived--> %s", eventMsg));
		
		WikkiediaData data=new WikkiediaData();
		data.setWikkiData(eventMsg);
		wikirepo.save(data);
		
	}
}
