package es.caser.archit.spring.dao;

import org.springframework.stereotype.Repository;

import es.caser.archit.spring.model.Employee;

@Repository
public class EmployeeDAOImpl extends GenericDAOImpl<Long, Employee> implements IEmployeeDAO{	

	public EmployeeDAOImpl() {
		super(Employee.class);
		
	}
}
