package com.vithal.code.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vithal.code.kafka.JsonKafkaProducer;
import com.vithal.code.kafka.payload.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

	private JsonKafkaProducer jsonKafkaProducer;

	public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
		this.jsonKafkaProducer = jsonKafkaProducer;
	}
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user){
		jsonKafkaProducer.sendMessage(user);
		return ResponseEntity.ok("JSON MESSAGE HAS BEEN SENT TO KAFKA TOPIC");
	}
}
