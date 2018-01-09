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

import es.caser.archit.spring.model.Task;
import es.caser.archit.spring.service.ITaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private ITaskService taskService;

	@GetMapping("/{id}")
	public Task getById(@PathVariable("id") Long id) {
		Task article = taskService.getById(id);
		return article;
	}

	@GetMapping
	public List<Task> getAll() {
		List<Task> list = taskService.getAll();
		return list;
	}

	@PostMapping
	public Task addArticle(@RequestBody Task element) {
		Task returned = taskService.add(element);
		
		return returned;
	}

	@PutMapping
	public Task update(@RequestBody Task element) {
		taskService.update(element);
		return element;
	}

	@DeleteMapping("/{id}")
	public Optional<Void> delete(@PathVariable("id") Long id) {
		taskService.delete(id);
		return Optional.empty();

	}
}
