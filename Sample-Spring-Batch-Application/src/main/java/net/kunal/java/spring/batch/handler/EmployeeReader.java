package net.kunal.java.spring.batch.handler;

import java.util.List;

import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import net.kunal.java.spring.batch.dao.EmployeeDao;
import net.kunal.java.spring.batch.model.Employee;

public class EmployeeReader implements ItemReader<Employee>,ItemReadListener<Employee> {
	
	@Autowired EmployeeDao employeeDao;
	int chunkIndex=0;
	boolean readFlag=Boolean.TRUE;
	
	@Value("#{stepExecutionContext[TO_PROCESS]}")
	private List<Employee> empChunk;		
	
	@Override
	public Employee read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if(empChunk.isEmpty() || !readFlag) {
			return null;
		}else {
			return empChunk.get(chunkIndex);
		}
	}

	@Override
	public void beforeRead() {
		System.out.println(empChunk.size());
		 if(chunkIndex>=empChunk.size()) {
			 readFlag=Boolean.FALSE;
		 }
	}

	@Override
	public void afterRead(Employee item) {
		chunkIndex++;
	}

	@Override
	public void onReadError(Exception ex) {
	}

}
