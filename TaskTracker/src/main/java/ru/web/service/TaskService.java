package ru.web.service;

import ru.web.forms.TaskForm;
import ru.web.models.Project;
import ru.web.models.Task;

import java.util.List;

public interface TaskService {
    void addTask(Integer projectId , TaskForm taskForm);

    List<Task> getTasksOfProject(Integer projectId);

    List<Task> getAllTasks();

    void deleteTask(Integer taskId);

    void updateTask(Integer taskId, TaskForm taskForm);

    Task getTask(Integer taskId);
}
