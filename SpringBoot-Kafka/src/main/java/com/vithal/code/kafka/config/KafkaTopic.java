package com.vithal.code.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {
	
	@Bean
	public NewTopic newTopic() {
		
		return TopicBuilder.name("vithal").build();
	}

	@Bean
	public NewTopic newTopics() {
		
		return TopicBuilder.name("vikki").build();
	}
}
