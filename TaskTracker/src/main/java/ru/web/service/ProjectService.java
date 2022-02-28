package ru.web.service;

import ru.web.forms.ProjectForm;
import ru.web.models.Project;

import java.util.List;

public interface ProjectService {

    void addProject(ProjectForm projectForm);

    List<Project> getAllProjects();

    void deleteProject(Integer projectId);

    Project getProject(Integer projectId);

    void update(Integer projectId , ProjectForm projectForm);
}
