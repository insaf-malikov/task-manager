package ru.web.forms;

import lombok.Data;
import ru.web.models.Project;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

//used for handling post requests
@Data
public class ProjectForm {
    @NotEmpty
    private String name;

    private Project.Status status;

    private Date startDate;

    private Date completeDate;

    @Min(1)
    @Max(5)
    private Integer priority;
}
