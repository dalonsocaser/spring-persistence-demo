package es.caser.archit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.caser.archit.spring.model.Employee;
import es.caser.archit.spring.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	private EmployeeRepository employeeDAo;
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeDAo) {
		super();
		this.employeeDAo = employeeDAo;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Employee> getAll() {
		
		return employeeDAo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Employee getById(Long key) {
		
		return employeeDAo.findOne(key);
	}

	@Override
	@Transactional
	public Employee add(Employee element) {
		employeeDAo.save(element);
		return element;
	}

	@Override
	@Transactional
	public void update(Employee element) {
	
		employeeDAo.save(element);
	}

	@Override
	@Transactional
	public void delete(Long key) {
	
		employeeDAo.delete(key);
	}

	@Override
	@Transactional(readOnly=true)
	public Employee getByAlias(String alias) {		
		return employeeDAo.findEmployeeWithCustomQuery(alias);
	}

}
