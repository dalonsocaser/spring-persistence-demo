package es.caser.archit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.caser.archit.spring.dao.ITaskDAO;
import es.caser.archit.spring.model.Task;
@Service
public class TaskServiceImpl implements ITaskService{
	
	private ITaskDAO taskDAO;
	@Autowired
	public TaskServiceImpl(ITaskDAO taskDAO) {
		super();
		this.taskDAO = taskDAO;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Task> getAll() {
		
		return taskDAO.getAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Task getById(Long key) {
		
		return taskDAO.getById(key);
	}

	@Override
	@Transactional
	public Task add(Task element) {
		taskDAO.add(element);
		return element;
	}

	@Override
	@Transactional
	public void update(Task element) {
	
		taskDAO.update(element);
	}

	@Override
	@Transactional
	public void delete(Long key) {
	
		taskDAO.delete(key);
	}

}
