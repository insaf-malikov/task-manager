package ru.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.web.models.Project;

@Component
public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
