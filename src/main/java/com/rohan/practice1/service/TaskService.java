package com.rohan.practice1.service;

import com.rohan.practice1.entity.TaskEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import com.rohan.practice1.repository.TaskRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Service

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskEntity createTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    public List<TaskEntity> getAllTasks () {
        return taskRepository.findAll();
    }

    public Optional<TaskEntity> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

//    Run and understand this endpoint today after coming back from office --> 12th March 2026
    public TaskEntity updateTaskById(Long id, TaskEntity task) {
        Optional<TaskEntity> existingTask = taskRepository.findById(id);
        TaskEntity existingTaskFromDB = existingTask.get();
        existingTaskFromDB.setTitle(task.getTitle());
        existingTaskFromDB.setDescription(task.getDescription());

        return taskRepository.save(existingTaskFromDB);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
