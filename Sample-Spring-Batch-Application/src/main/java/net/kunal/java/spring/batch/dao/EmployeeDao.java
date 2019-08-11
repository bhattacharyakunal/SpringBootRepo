package net.kunal.java.spring.batch.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import net.kunal.java.spring.batch.model.Employee;

@Repository
public class EmployeeDao {
	@Autowired private JdbcTemplate jdbcTemplate;
	
	public List<Employee> getEmployeeList(){
		String sql="select employeeId,employeeName,employeeSalary,isActive from employee";
		RowMapper<Employee> employeeMapper=new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee=new Employee();
				employee.setEmployeeId(rs.getLong(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setEmployeeSalary(rs.getDouble(3));
				employee.setIsActive(rs.getString(4));
				return employee;
			}
		};
		return jdbcTemplate.query(sql, employeeMapper);
	}
	
	public Employee getEmployee() {
		return getEmployeeList().get(0);
	}
}
