package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.education.University;
import by.bsuir.ceres.dao.UniversityRepository;
import by.bsuir.ceres.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public List<University> getAllUniversities() {

        return (List<University>) universityRepository.findAll();
    }

    @Override
    public University getUniversityById(Long id) {

        return universityRepository.findOne(id);
    }

    @Override
    public void createUniversity(University university) {

        universityRepository.save(university);
    }

    @Override
    public void updateUniversityById(University university) {

        universityRepository.save(university);
    }

    @Override
    public void deleteUniversityById(Long id) {

        universityRepository.delete(id);
    }
}
