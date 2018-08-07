package com.accolite.aman.SpringBatchCsvProcessor.service.consumer;

import com.accolite.aman.SpringBatchCsvProcessor.model.User;
import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	private static final Logger logger = Logger.getLogger(KafkaConsumerService.class);


	@KafkaListener(containerFactory = "kafkaListenerContainerFactory",
			topics = "${kafka.csv.topic}", groupId = "${kafka.csv.group.id}")
	public void consume(User user){
		logger.info("Consuming new message: " + user.getName() + " -> " + user);
	}


}
