package net.kunal.java.spring.batch.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

import net.kunal.java.spring.batch.dao.EmployeeDao;
import net.kunal.java.spring.batch.model.Employee;

public class EmployeePartitioner implements Partitioner {
	
	@Autowired EmployeeDao employeeDao;
	List<Employee> empList;
	private static final int CHUNK_SIZE=2;
	
	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		int index;
		Map<String, ExecutionContext> result= new HashMap<String, ExecutionContext>();
//		List<List<Employee>> empChunk=buildChunk(empList,CHUNK_SIZE);
		empList=employeeDao.getEmployeeList();
		for(index=0;index<empList.size();index++) {
			Employee emp=empList.get(index);
			System.out.println(index+" ::::::::::"+emp);
			ExecutionContext value = new ExecutionContext();
			value.put("TO_PROCESS", emp);
			result.put("Partition"+index, value);
		}
			
		return result;
	}

	/*
	 * private List<Employee> buildChunk(List<Employee> empList2, int chunkSize) {
	 * List<List<Employee>> empChunk=new ArrayList<>(); for(int
	 * i=0;i<empList2.size();i=i+chunkSize) { empChunk.add(empList2.subList(i,
	 * i+chunkSize-1)); } return empChunk; }
	 */


}
