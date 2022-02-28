package ru.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//project Id generated automatically
    private String name;

    public enum Status {
        NotStarted , Active , Completed
    }
    @Enumerated(value = EnumType.STRING)
    private Status status;

    private Date startDate;
    private Date completeDate;

    private Integer priority; //priority scale 1 to 5, where 1-low priority, 5-high priority

   @OneToMany(mappedBy = "project")//creating relation between one projects and its tasks
    private List<Task> tasks;
}
