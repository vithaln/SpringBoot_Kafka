package com.vithal.code.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
	
	@Value("${spring.kafka.topic.name}")
	private String tpoicName;

	
	//spring Bean for kafka
	@Bean
	public NewTopic newTopic() {
		
		return TopicBuilder.name(tpoicName).build();
	}
}
