package com.accolite.aman.SpringBatchCsvProcessor.batch;

import com.accolite.aman.SpringBatchCsvProcessor.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserProcessor implements ItemProcessor<User, User> {

	@Override
	public User process(User user) throws Exception {
		user.setId(1L);
		user.setDate(new Date());
		return user;
	}
}
