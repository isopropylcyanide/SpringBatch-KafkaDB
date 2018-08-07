package com.accolite.aman.SpringBatchCsvProcessor.service.producer;

import com.accolite.aman.SpringBatchCsvProcessor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class KafkaProducerService {

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	@Value("${kafka.csv.topic}")
	private String topic;

	/**
	 * Created using the following
	 * 1) zookeeper-server-start.bat ..\..\config\zookeeper.properties
	 * 2) kafka-server-start.bat ..\..\config\server.properties
	 * 3) Create topic:
	 * 		kafka-topics.bat --create --zookeeper localhost:2181
	 * 	   --replication-factor 1 --partitions 1 --topic KAFKA_EXAMPLE_TOPIC
	 * 4) Consume from console:
	 * 		kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic KAFKA_EXAMPLE_TOPIC
	 * 		--from-beginning
	 * 5) Produce from console:
	 * 		 kafka-console-producer.bat --broker-list localhost:9092 --topic KAFKA_EXAMPLE_TOPIC
	 * @param name

	 * @return
	 */
	public String publishUserByName(String name) {
		User user = new User();
		user.setId(1L);
		user.setName(name);
		user.setDepartment("00X");
		user.setSalary(12000);
		user.setDate(new Date());
		kafkaTemplate.send(topic, user);
		return "Published successfully: " + user;
	}
}
