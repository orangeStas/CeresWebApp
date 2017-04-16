package by.bsuir.ceres.dao;

import by.bsuir.ceres.bean.Project;
import by.bsuir.ceres.bean.Student;
import by.bsuir.ceres.bean.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    Set<Project> findByAuthor(Student student);
}
