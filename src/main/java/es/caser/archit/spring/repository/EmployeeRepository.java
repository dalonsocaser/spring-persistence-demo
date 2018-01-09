package es.caser.archit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.caser.archit.spring.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
