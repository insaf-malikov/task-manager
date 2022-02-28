package ru.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//task Id generated automatically

    private String name;
    private String description;

    public enum Status {
        ToDo , InProgress , Done
    }
    @Enumerated(value = EnumType.STRING)
    private Status status;

    private Integer priority; //priority scale 1 to 5, where 1-low priority, 5-high priority

    @ManyToOne//creating relation between one projects and its tasks
    @JoinColumn(name="project_id")
    private Project project;
}
