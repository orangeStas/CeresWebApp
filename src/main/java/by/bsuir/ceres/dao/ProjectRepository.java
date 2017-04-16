package by.bsuir.ceres.dao;

import by.bsuir.ceres.bean.Project;
import by.bsuir.ceres.bean.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    Set<Project> findByAuthorOrParticipants(Student student, Set<Student> students);
}
