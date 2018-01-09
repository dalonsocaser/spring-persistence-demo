package es.caser.archit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.caser.archit.spring.model.Task;
import es.caser.archit.spring.repository.TaskRepository;
@Service
public class TaskServiceImpl implements ITaskService{
	
	private TaskRepository taskDAO;
	@Autowired
	public TaskServiceImpl(TaskRepository taskDAO) {
		super();
		this.taskDAO = taskDAO;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Task> getAll() {
		
		return taskDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Task getById(Long key) {
		
		return taskDAO.findOne(key);
	}

	@Override
	@Transactional
	public Task add(Task element) {
		taskDAO.save(element);
		return element;
	}

	@Override
	@Transactional
	public void update(Task element) {
	
		taskDAO.save(element);
	}

	@Override
	@Transactional
	public void delete(Long key) {
	
		taskDAO.delete(key);
	}

}
