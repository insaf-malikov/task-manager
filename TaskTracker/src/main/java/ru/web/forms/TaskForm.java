package ru.web.forms;


import lombok.Data;
import ru.web.models.Task;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

//used for handling post requests
@Data
public class TaskForm {

    @NotEmpty
    private String name;

    private Task.Status status;

    private String description;

    @Min(1)
    @Max(5)
    private Integer priority;
}
