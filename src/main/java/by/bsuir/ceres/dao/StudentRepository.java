package by.bsuir.ceres.dao;

import by.bsuir.ceres.bean.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
