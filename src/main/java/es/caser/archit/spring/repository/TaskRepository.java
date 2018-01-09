package es.caser.archit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.caser.archit.spring.model.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
