package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.education.Speciality;

import java.util.List;

public interface SpecialityService {

    List<Speciality> getAllSpecialities();
    Speciality getSpecialityById(Long id);
    void createSpeciality(Speciality speciality);
    void updateSpecialityById(Speciality speciality);
    void deleteSpecialityById(Long id);
    List<Speciality> getSpecialitiesByFaculty(Long facultyId);
}
