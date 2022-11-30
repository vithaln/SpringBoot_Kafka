package com.vithal.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vithal.code.service.WikkiMediaChangesProducer;

@SpringBootApplication
public class SpringBootRealTimeProjectKafkaProducerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRealTimeProjectKafkaProducerApplication.class, args);
	}
	
	@Autowired
	private WikkiMediaChangesProducer changesProducer;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		changesProducer.sendMessage();
	}

}
