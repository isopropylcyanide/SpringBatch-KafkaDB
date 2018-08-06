package com.accolite.aman.SpringBatchCsvProcessor.batch;

import com.accolite.aman.SpringBatchCsvProcessor.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserProcessor implements ItemProcessor<User, User> {

	private static final Map<String, String> deptMap = new HashMap<>();

	public UserProcessor() {
		deptMap.put("001", "Computers");
		deptMap.put("002", "Electronics");
		deptMap.put("003", "Mechanical");
	}

	@Override
	public User process(User user) throws Exception {
		String deptCode = user.getDepartment();
		String deptName = deptMap.getOrDefault(deptCode, "Miscellaneous");
		user.setDepartment(deptName);
		System.out.println(String.format("User dept converted from [%s] to [%s]", deptCode, deptName));
		return user;
	}
}
