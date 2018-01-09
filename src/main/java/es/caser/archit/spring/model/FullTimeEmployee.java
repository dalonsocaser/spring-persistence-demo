package es.caser.archit.spring.model;

public class FullTimeEmployee extends Employee {
	protected Integer salary;

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
}
