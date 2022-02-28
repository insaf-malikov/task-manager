package ru.web.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.web.models.Task;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task,Integer> {

    List<Task> findAllByProject_Id(Integer projectId);
}
