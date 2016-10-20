package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.education.Faculty;
import by.bsuir.ceres.dao.FacultyRepository;
import by.bsuir.ceres.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getAllFaculties() {

        return (List<Faculty>) facultyRepository.findAll();
    }

    @Override
    public Faculty getFacultyById(Long id) {

        return facultyRepository.findOne(id);
    }

    @Override
    public void createFaculty(Faculty faculty) {

        facultyRepository.save(faculty);
    }

    @Override
    public void updateFacultyById(Faculty faculty) {

        facultyRepository.save(faculty);
    }

    @Override
    public void deleteFacultyById(Long id) {

        facultyRepository.delete(id);
    }
}
