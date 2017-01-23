package by.bsuir.ceres.dao;

import by.bsuir.ceres.bean.education.Faculty;
import by.bsuir.ceres.bean.education.University;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface FacultyRepository extends CrudRepository<Faculty, Long> {
    Set<Faculty> findByUniversity(University university);
}
