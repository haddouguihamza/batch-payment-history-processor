package com.example.balance.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.balance.dao.OutputDetailRecord;
import com.example.balance.dao.RecordNotFoundException;
import com.example.balance.dao.BalanceRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
@CrossOrigin(origins = "*")
public class BalanceController implements JobExecutionListener {

    private BalanceRepository balanceRepository= null;
	
	@Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;
    
    private static final Logger log = LoggerFactory.getLogger(BalanceController.class);
    
    public BalanceController() {
    	
    }
    
    public BalanceController(BalanceRepository repository) {
		this.balanceRepository= repository;
	}

    @Override
    public void beforeJob(JobExecution jobExecution) {
        // Logic before job execution (if needed)
        jobExecution.getExecutionContext().put("start_time", System.currentTimeMillis());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            long startTime = (long) jobExecution.getExecutionContext().get("start_time");
            long endTime = System.currentTimeMillis();
            long timeSpent = endTime - startTime;
            log.info("Job completed in " + timeSpent + " milliseconds");
        }
    }

    @GetMapping("/balance-job")
    public BatchStatus load() throws Exception {
        JobParameters jobParameters = new JobParameters();
        JobExecution jobExecution = jobLauncher.run(job, jobParameters);
        while (jobExecution.isRunning()) {
            System.out.println("....");
        }

        return jobExecution.getStatus();
    }
	
	
	
    @GetMapping("/balance-records")
    public CollectionModel<EntityModel<OutputDetailRecord>> all() {
        // Use findAll() to fetch all records from the repository
        List<EntityModel<OutputDetailRecord>> records = balanceRepository.findAll()
            .stream() // Start streaming the list
            .map((OutputDetailRecord record) -> EntityModel.of(record, // Wrap each record in an EntityModel
                // Add self link for individual record
                linkTo(methodOn(BalanceController.class).one(record.getBalance_id())).withSelfRel(),
                // Add link to the collection of records
                linkTo(methodOn(BalanceController.class).all()).withRel("balance-records")))
            .collect(Collectors.toList()); // Collect the stream into a list

        // Wrap the list in a CollectionModel and add a self link for the whole collection
        return CollectionModel.of(records,
            linkTo(methodOn(BalanceController.class).all()).withSelfRel());
    }
    
    

    // Example method to retrieve a single record (required for self-link generation)
    @GetMapping("/balance-records/{id}")
    public EntityModel<OutputDetailRecord> one(@PathVariable Long id) {
        OutputDetailRecord record = balanceRepository.findById(id)
            .orElseThrow(() -> new RecordNotFoundException(id));
        return EntityModel.of(record,
            linkTo(methodOn(BalanceController.class).one(id)).withSelfRel(),
            linkTo(methodOn(BalanceController.class).all()).withRel("balance-records"));
    }

}
