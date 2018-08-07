package com.accolite.aman.SpringBatchCsvProcessor.service.consumer;

import com.accolite.aman.SpringBatchCsvProcessor.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	@KafkaListener(topics = "KAFKA_EXAMPLE_TOPIC", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
	public void consume(User user){
		System.out.println("Consuming new message: " + user.getName() + " -> " + user);
	}


}
