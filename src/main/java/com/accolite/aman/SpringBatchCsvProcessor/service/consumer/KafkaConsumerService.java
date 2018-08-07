package com.accolite.aman.SpringBatchCsvProcessor.service.consumer;

import com.accolite.aman.SpringBatchCsvProcessor.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	@Autowired
	private Logger logger;

	@KafkaListener(topics = "${kafka.csv.topic}", groupId = "${kafka.csv.group.id}")
	public void consume(User user){
		logger.info("Consuming new message: " + user.getName() + " -> " + user);
	}


}
