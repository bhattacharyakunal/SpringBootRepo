package net.kunal.java.spring.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobLauncherController {
	
	@Autowired Job textProcessingJob;
	@Autowired JobLauncher jobLauncher;
	
	@PostMapping("/launchJob")
	public ResponseEntity<String> startJob() throws Exception{
		JobParameters params = new JobParametersBuilder()
                .addString("JobRunTime", String.valueOf(System.currentTimeMillis())).toJobParameters();
		jobLauncher.run(textProcessingJob, params);
		return ResponseEntity.accepted().body("Job Started Successfully");
	}
}
