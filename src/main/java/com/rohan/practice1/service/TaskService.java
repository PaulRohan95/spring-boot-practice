package com.rohan.practice1.service;

import com.rohan.practice1.entity.TaskEntity;
import org.springframework.stereotype.Service;
import com.rohan.practice1.repository.TaskRepository;

import java.util.List;
import java.util.Optional;


@Service // Spring annotation specifies that it is a spring bean, and thus managed by spring

// Following methods are inherited by TaskRepository from JpaRepository due to TaskRepository extends JpaRepository <TaskEntity, Long> {
//
//}
// save()
// findAll()
// findById()


public class TaskService {
    private final TaskRepository taskRepository; // Respository layer dependency injected by Spring

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    } // creating

    public TaskEntity createTask(TaskEntity task) {
        return taskRepository.save(task);
    } // Logic for creating a task, the structure of which is defined in TaskEntity (hence the dependency injection)
    // Saving the task after it has been created (handled by save())

    public List<TaskEntity> getAllTasks () {
        return taskRepository.findAll();
    } // Returns a list of all the tasks present in the database.

    public Optional<TaskEntity> getTaskById(Long id) {
        return taskRepository.findById(id);
    } // the task may or may not exist (hence the optional wrapper). fetching an existing task by its id only if it's present.


    public TaskEntity updateTaskById(Long id, TaskEntity task) { // updating task
        Optional<TaskEntity> existingTask = taskRepository.findById(id); // find it by id (may or may not exist, hence the Optional wrapper)
        TaskEntity existingTaskFromDB = existingTask.get(); // get the existing task from DB, where TaskEntity defines the data structure
        existingTaskFromDB.setTitle(task.getTitle()); // updating the title of the existing task
        existingTaskFromDB.setDescription(task.getDescription()); // updating the description of the existing task

        return taskRepository.save(existingTaskFromDB); // saving the UPDATED task in the db
        // Jpa checks if the entity has an id value. If yes --> update the task. If no --> Insert the task
        // The findById(), set() defines what to do with the task. The Jpa check defines how to do it
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    } // deleting an existing task by id
}
