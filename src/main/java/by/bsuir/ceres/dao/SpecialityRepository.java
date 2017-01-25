package by.bsuir.ceres.dao;

import by.bsuir.ceres.bean.education.Faculty;
import by.bsuir.ceres.bean.education.Speciality;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
    Set<Speciality> findByFaculty(Faculty faculty);
}
