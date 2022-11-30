package com.vithal.code.service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikkiMediaChangesProducer {
	
	private static final Logger log=LoggerFactory.getLogger(WikkiMediaChangesProducer.class);
	
	private KafkaTemplate< String, String> kafkaTemplate;

	public WikkiMediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {

		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage() throws InterruptedException {
		String topic="wikimedia";
		
		// to read realtime stream data from wikkimwdia, we use event source
		
		EventHandler eventHandler=new WikkiMediaChangesHandler(kafkaTemplate, topic);
		
		String url="https://stream.wikimedia.org/v2/stream/recentchange";
		
		EventSource.Builder builder=new EventSource.Builder(eventHandler, URI.create(url));
		EventSource eventSource = builder.build();
		eventSource.start();
		
		TimeUnit.MINUTES.sleep(10);
	}
}
