package by.bsuir.ceres.dao;

import by.bsuir.ceres.bean.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByNameAndMiddleNameAndSurname(String name, String middleName, String surname);
}
