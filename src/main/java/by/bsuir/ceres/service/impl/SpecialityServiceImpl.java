package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.education.Faculty;
import by.bsuir.ceres.bean.education.Speciality;
import by.bsuir.ceres.dao.SpecialityRepository;
import by.bsuir.ceres.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;

    @Override
    public List<Speciality> getAllSpecialities() {

        return (List<Speciality>) specialityRepository.findAll();
    }

    @Override
    public Speciality getSpecialityById(Long id) {

        return specialityRepository.findOne(id);
    }

    @Override
    public void createSpeciality(Speciality speciality) {

        specialityRepository.save(speciality);
    }

    @Override
    public void updateSpecialityById(Speciality speciality) {

        specialityRepository.save(speciality);
    }

    @Override
    public void deleteSpecialityById(Long id) {

        specialityRepository.delete(id);
    }

    @Override
    public List<Speciality> getSpecialitiesByFaculty(Long facultyId) {
        Faculty faculty = new Faculty();
        faculty.setId(facultyId);
        return new ArrayList<>(specialityRepository.findByFaculty(faculty));
    }
}
