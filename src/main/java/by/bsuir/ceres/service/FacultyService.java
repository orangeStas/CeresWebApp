package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.education.Faculty;

import java.util.List;

public interface FacultyService {

    List<Faculty> getAllFaculties();
    Faculty getFacultyById(Long id);
    void createFaculty(Faculty faculty);
    void updateFacultyById(Faculty faculty);
    void deleteFacultyById(Long id);
}
