package es.caser.archit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.caser.archit.spring.model.Employee;
import es.caser.archit.spring.service.IEmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private IEmployeeService employeeService;

	@GetMapping("/{alias}")
	public Employee getById(@PathVariable("alias") String alias) {
		Employee article = employeeService.getByAlias(alias);
		return article;
	}

	@GetMapping
	public List<Employee> getAll() {
		List<Employee> list = employeeService.getAll();
		return list;
	}

	@PostMapping
	public Employee addArticle(@RequestBody Employee element) {
		Employee returned = employeeService.add(element);
		
		return returned;
	}

	@PutMapping
	public Employee update(@RequestBody Employee element) {
		employeeService.update(element);
		return element;
	}

	@DeleteMapping("/{id}")
	public Optional<Void> delete(@PathVariable("id") Long id) {
		employeeService.delete(id);
		return Optional.empty();

	}
}
