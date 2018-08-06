package com.accolite.aman.SpringBatchCsvProcessor.controller;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/load")
public class LoadController {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	@GetMapping()
	public BatchStatus load() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
		Map<String, JobParameter> jobParametersMap = new HashMap<>();
		jobParametersMap.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters parameters = new JobParameters(jobParametersMap);
		JobExecution jobExecution = jobLauncher.run(job, parameters);

		System.out.println("Job Execution: " + jobExecution.getStatus());
		System.out.println("Batch job is running");

		while (jobExecution.isRunning()){
			System.out.println("...");
		}
		return jobExecution.getStatus();
	}
}
