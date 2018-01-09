package es.caser.archit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.caser.archit.spring.dao.IEmployeeDAO;
import es.caser.archit.spring.model.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	private IEmployeeDAO employeeDAo;
	@Autowired
	public EmployeeServiceImpl(IEmployeeDAO employeeDAo) {
		super();
		this.employeeDAo = employeeDAo;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Employee> getAll() {
		
		return employeeDAo.getAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Employee getById(Long key) {
		
		return employeeDAo.getById(key);
	}

	@Override
	@Transactional
	public Employee add(Employee element) {
		employeeDAo.add(element);
		return element;
	}

	@Override
	@Transactional
	public void update(Employee element) {
	
		employeeDAo.update(element);
	}

	@Override
	@Transactional
	public void delete(Long key) {
	
		employeeDAo.delete(key);
	}

}
