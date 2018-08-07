package com.accolite.aman.SpringBatchCsvProcessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:kafka.properties")
public class SpringBatchCsvProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchCsvProcessorApplication.class, args);
	}

}
