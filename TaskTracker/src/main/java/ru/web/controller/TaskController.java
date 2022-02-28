package ru.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.web.forms.TaskForm;
import ru.web.models.Project;
import ru.web.models.Task;
import ru.web.service.ProjectService;
import ru.web.service.TaskService;

import javax.validation.Valid;


@Controller
public class TaskController {

private final TaskService taskService;
private final ProjectService projectService;

@Autowired
    public TaskController(TaskService taskService, ProjectService projectService) {
        this.taskService = taskService;
        this.projectService = projectService;
    }

    //adding tasks to the specified project
    @PostMapping("/task/add")
    public String addTask( Integer projectId ,@Valid TaskForm taskForm){
        taskService.addTask(projectId, taskForm);
        return "redirect:/projects/" + projectId;
    }

    // deletes task
    @PostMapping("/projects/{project-id}/task/{task-id}/delete")
    public  String deleteTask(@PathVariable("task-id") Integer taskId, @PathVariable("project-id") Integer projectId) {
        taskService.deleteTask(taskId);
        return "redirect:/projects/" + projectId;
    }

    //opens task info page
    @GetMapping("/projects/{project-id}/task/{task-id}")
    public String getTaskPage(Model model, @PathVariable("task-id") Integer taskId, @PathVariable("project-id") Integer projectId) {
        Task task = taskService.getTask(taskId);
        Project project = projectService.getProject(projectId);
        model.addAttribute("task", task);
        model.addAttribute("project", project);
        return "task_edit";
    }

    //task info editing
    @PostMapping("/projects/{project-id}/task/{task-id}/update")
    public  String updateTask(@PathVariable("task-id") Integer taskId, @PathVariable("project-id") Integer projectId,@Valid TaskForm taskForm) {
        taskService.updateTask(taskId, taskForm);
        return "redirect:/projects/" + projectId;
    }
}
