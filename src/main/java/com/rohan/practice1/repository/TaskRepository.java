package com.rohan.practice1.repository;

import com.rohan.practice1.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository <TaskEntity, Long> {

}