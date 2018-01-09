package es.caser.archit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.caser.archit.spring.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	public Employee readEmployeeByAlias(String alias);
	@Query("select s from Employee s where s.alias like %:alias")
	public Employee findEmployeeWithCustomQuery(@Param("alias") String alias);
}
