/**
 * 
 */
package com.example.balance.job.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfiguration {
	
	@Bean
	Job job(JobRepository repository, Step one) {
		return new JobBuilder("balance-job", repository)
			.start(one)
			.build();
	}

}
