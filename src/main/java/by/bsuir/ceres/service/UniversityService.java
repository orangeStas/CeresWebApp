package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.education.University;

import java.util.List;

public interface UniversityService {

    List<University> getAllUniversities();
    University getUniversityById(Long id);
    void createUniversity(University university);
    void updateUniversityById(University university);
    void deleteUniversityById(Long id);
}
