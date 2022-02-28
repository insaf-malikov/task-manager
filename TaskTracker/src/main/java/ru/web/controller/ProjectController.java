package ru.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.web.forms.ProjectForm;
import ru.web.models.Project;
import ru.web.models.Task;
import ru.web.service.ProjectService;
import ru.web.service.TaskService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProjectController {
    private final TaskService taskService;
    private final ProjectService projectService;

    @Autowired
    public ProjectController(TaskService taskService, ProjectService projectService) {
        this.taskService = taskService;
        this.projectService = projectService;
    }

    //creating project
    @PostMapping("/projects/add")
    public String addProject(@Valid ProjectForm projectForm){
        projectService.addProject(projectForm);
        return "redirect:/projects";
    }

    //list all projects
    @GetMapping("/projects")
    public String getProjectsPage(Model model) {
        List<Project> projects = projectService.getAllProjects();
        model.addAttribute("projects", projects);
        return "projects";
    }

    //delete project
    @PostMapping("/projects/{project-id}/delete")
    public  String deleteProject(@PathVariable("project-id") Integer projectId) {
        projectService.deleteProject(projectId);
        return "redirect:/projects";
    }

    //opens project page with its tasks
    @GetMapping("/projects/{project-id}")
    public String getProjectPage(Model model, @PathVariable("project-id") Integer projectId) {
        Project project = projectService.getProject(projectId);
        List<Task> tasks = taskService.getTasksOfProject(projectId);
        model.addAttribute("project", project);
        model.addAttribute("tasks", tasks);
        return "project";
    }

    //updates project info
    @PostMapping("/projects/{project-id}/update")
    public  String update(@PathVariable("project-id") Integer projectId, @Valid ProjectForm projectForm) {
        projectService.update(projectId, projectForm);
        return "redirect:/projects";
    }
}
