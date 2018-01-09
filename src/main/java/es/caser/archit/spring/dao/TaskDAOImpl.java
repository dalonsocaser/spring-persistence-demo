package es.caser.archit.spring.dao;

import org.springframework.stereotype.Repository;

import es.caser.archit.spring.model.Task;

@Repository
public class TaskDAOImpl extends GenericDAOImpl<Long, Task> implements ITaskDAO{	

	public TaskDAOImpl() {
		super(Task.class);
		
	}
}
