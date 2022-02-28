package ru.web.service;

import org.springframework.stereotype.Component;
import ru.web.forms.TaskForm;
import ru.web.models.Project;
import ru.web.models.Task;
import ru.web.repositories.ProjectRepository;
import ru.web.repositories.TaskRepository;

import java.util.List;

@Component
public class TaskServiceImpl implements TaskService {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public TaskServiceImpl(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void addTask(Integer projectId , TaskForm taskForm) {
            Task task = Task.builder()
                    .name(taskForm.getName())
                    .status(taskForm.getStatus())
                    .priority(taskForm.getPriority())
                    .description(taskForm.getDescription())
                    .build();
            Project project = projectRepository.getById(projectId);
            task.setProject(project);
            taskRepository.save(task);
    }

    @Override
    public List<Task> getTasksOfProject(Integer projectId) {
        return taskRepository.findAllByProject_Id(projectId);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(Integer taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public void updateTask(Integer taskId, TaskForm taskForm) {
        Task task = taskRepository.getById(taskId);
        task.setName(taskForm.getName());
        task.setStatus(taskForm.getStatus());
        task.setPriority(taskForm.getPriority());
        task.setDescription(taskForm.getDescription());
        taskRepository.save(task);
    }

    @Override
    public Task getTask(Integer taskId) {
        return taskRepository.getById(taskId);
    }
}
