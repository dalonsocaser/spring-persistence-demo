package es.caser.archit.spring.model;

public class PartTimeEmployee extends Employee {
	protected Float hourlyWage;

	public Float getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(Float hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	
}
