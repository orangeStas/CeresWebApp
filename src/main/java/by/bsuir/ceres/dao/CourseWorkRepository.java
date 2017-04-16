package by.bsuir.ceres.dao;

import by.bsuir.ceres.bean.CourseWork;
import by.bsuir.ceres.bean.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * Created by wowru on 11/20/2016.
 */

public interface CourseWorkRepository extends CrudRepository<CourseWork, Long> {
    Set<CourseWork> findByStudent(Student student);
}
