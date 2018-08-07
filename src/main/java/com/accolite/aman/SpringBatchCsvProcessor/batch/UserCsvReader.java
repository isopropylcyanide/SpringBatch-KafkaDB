package com.accolite.aman.SpringBatchCsvProcessor.batch;

import com.accolite.aman.SpringBatchCsvProcessor.model.User;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class UserCsvReader implements ItemReader<User> {

	@Value("${input.csv.file}")
	private Resource resource;

	@Bean
	public FlatFileItemReader<User> itemReader(){
		FlatFileItemReader<User> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(resource);
		flatFileItemReader.setName("CSV Reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(getLineMapper());
		return flatFileItemReader;
	}

	@Bean
	public LineMapper<User> getLineMapper() {
		DefaultLineMapper<User> userLineMapper = new DefaultLineMapper<User>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("id", "name", "department", "salary");

		BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(User.class);
		userLineMapper.setLineTokenizer(lineTokenizer);
		userLineMapper.setFieldSetMapper(fieldSetMapper);
		return userLineMapper;
	}


	@Override
	public User read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		return null;
	}
}
