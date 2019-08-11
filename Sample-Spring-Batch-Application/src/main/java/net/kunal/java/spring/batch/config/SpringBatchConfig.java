package net.kunal.java.spring.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import net.kunal.java.spring.batch.handler.EmployeePartitioner;
import net.kunal.java.spring.batch.handler.EmployeeProcessor;
import net.kunal.java.spring.batch.handler.EmployeeReader;
import net.kunal.java.spring.batch.handler.EmployeeWriter;
import net.kunal.java.spring.batch.model.Employee;

@EnableBatchProcessing
@Configuration
@EnableAutoConfiguration
public class SpringBatchConfig {
	
	@Autowired private JobBuilderFactory jobBuilderFactory;
	@Autowired private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	@Qualifier("textProcessingJob")
	public Job gettextProcessingJob() {
		return jobBuilderFactory.get("textProcessingJob")
				.incrementer(new RunIdIncrementer())
				.start(partionStep())
				.build();
	}
	
	@Bean
	public Step partionStep() {
		return stepBuilderFactory.get("partionStep")
			   .partitioner("textProcessingStep",partioner())
			   .step(textProcessingStep())
			   .taskExecutor(taskExecutor())
			   .build();
	}
	
	@Bean
	public TaskExecutor taskExecutor() {
		return new SimpleAsyncTaskExecutor();
	}
	
	@Bean
	public EmployeePartitioner partioner() {
		return new EmployeePartitioner();
	}
	
	@Bean
	@Qualifier("textProcessingStep")
	public Step textProcessingStep() {
		return stepBuilderFactory.get("textProcessingStep")
				.<Employee,Employee>chunk(1)
				.reader(readEmployeeData())
				.processor(processEmployeeData())
				.writer(writeEmployeeData())
				.build();
	}
	
	@Bean
	@StepScope
	public EmployeeReader readEmployeeData(){
		return new EmployeeReader();
	}
	@Bean
	@StepScope
	public EmployeeProcessor processEmployeeData(){
		return new EmployeeProcessor();
	}
	@Bean
	@StepScope
	public EmployeeWriter writeEmployeeData(){
		return new EmployeeWriter();
	}
	
	/*
	 * @Bean public JAXBContext getJc() throws JAXBException { JAXBContext
	 * jc=JAXBContext.newInstance(Employees.class); return jc; }
	 * 
	 * @Bean public EmployeeUtil getEmployeeUtil() throws JAXBException {
	 * EmployeeUtil empUtil=new EmployeeUtil(); empUtil.setJc(getJc()); return
	 * empUtil; }
	 */
}
