package ru.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.web.forms.ProjectForm;
import ru.web.models.Project;
import ru.web.repositories.ProjectRepository;
import ru.web.repositories.TaskRepository;

import java.util.List;

@Component
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void addProject(ProjectForm projectForm) {
        Project project = Project.builder()
                .name(projectForm.getName())
                .status(projectForm.getStatus())
                .priority(projectForm.getPriority())
                .startDate(projectForm.getStartDate())
                .completeDate(projectForm.getCompleteDate())
                .build();
        projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProject(Integer projectId) {
        projectRepository.deleteById(projectId);
    }

    @Override
    public Project getProject(Integer projectId) {
        return projectRepository.findById(projectId).orElseThrow();
    }

    @Override
    public void update(Integer projectId, ProjectForm projectForm) {
        Project project = projectRepository.getById(projectId);
        project.setName(projectForm.getName());
        project.setStatus(projectForm.getStatus());
        project.setPriority(projectForm.getPriority());
        project.setStartDate(projectForm.getStartDate());
        project.setCompleteDate(projectForm.getCompleteDate());
      projectRepository.save(project);
    }
}
