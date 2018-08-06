package com.accolite.aman.SpringBatchCsvProcessor.batch;

import com.accolite.aman.SpringBatchCsvProcessor.model.User;
import com.accolite.aman.SpringBatchCsvProcessor.repository.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDbWriter implements ItemWriter<User> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void write(List<? extends User> users) throws Exception {
		System.out.println("Saving user list: " + users);
		userRepository.saveAll(users);
	}
}
