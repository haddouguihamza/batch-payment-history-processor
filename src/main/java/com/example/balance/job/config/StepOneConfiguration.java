package com.example.balance.job.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.transaction.PlatformTransactionManager;
import com.example.balance.dao.InputDetailRecord;
import com.example.balance.dao.OutputDetailRecord;


@Configuration
public class StepOneConfiguration {
	
	private static final Resource inputFileResource = new ClassPathResource("/input.csv");
	
	int totalLines = countLines(inputFileResource);
    int linesToProcess = totalLines - 2; // Skip the headline and last summary line
	
	@Autowired
	private BalanceItemProcessor balanceItemProcessor;

	public StepOneConfiguration() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Bean
	FlatFileItemReader<InputDetailRecord> balanceCsvItemReader() {
		DefaultLineMapper<InputDetailRecord> lineMapper = new DefaultLineMapper<InputDetailRecord>();
		lineMapper.setFieldSetMapper(new BalanceFieldSetMapper());
		
		return new FlatFileItemReaderBuilder<InputDetailRecord>()
			.name("balanceRecordsCsvItemReader")
			.resource(inputFileResource)
			.linesToSkip(1)
			.maxItemCount(linesToProcess)
			.lineTokenizer(new DelimitedLineTokenizer(","))
			.lineMapper(lineMapper)
			.build();
	}
	
	
	@Bean
	ItemWriter<OutputDetailRecord> balanceItemWriter() {
		return chunk -> chunk.forEach(System.out::println);
	}
	
	
	@Bean
	Step firstStep(JobRepository repository, PlatformTransactionManager txm,
			FlatFileItemReader<InputDetailRecord> balanceReader,
			ItemWriter<OutputDetailRecord> balanceWriter) {
		return new StepBuilder("one", repository)
			.<InputDetailRecord, OutputDetailRecord>chunk(10, txm)
			.reader(balanceReader)
			.processor(this.balanceItemProcessor)
			.writer(balanceWriter)
			.build();
	}
	
	
	
	// Utility method to count lines in the file
	private int countLines(Resource resource) {
	    BufferedReader reader= null;
		try {
			reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return (int) reader.lines().count();
	}
	
}
