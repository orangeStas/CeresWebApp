package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.CourseWork;
import by.bsuir.ceres.bean.Student;
import by.bsuir.ceres.dao.CourseWorkRepository;
import by.bsuir.ceres.service.CourseWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wowru on 11/20/2016.
 */

@Service
public class CourseWorkServiceImpl implements CourseWorkService {

    @Autowired
    CourseWorkRepository courseWorkRepository;

    @Override
    public List<CourseWork> getAllCourseWorks() {

        return (List<CourseWork>) courseWorkRepository.findAll();
    }

    @Override
    public CourseWork getCourseWorkById(Long id) {

        return courseWorkRepository.findOne(id);
    }

    @Override
    public void createCourseWork(CourseWork courseWork) {

        courseWorkRepository.save(courseWork);
    }

    @Override
    public void updateCourseWorkById(CourseWork courseWork) {

        courseWorkRepository.save(courseWork);
    }

    @Override
    public void deleteCourseWorkById(Long id) {

        courseWorkRepository.delete(id);
    }

    @Override
    public List<CourseWork> getCourseWorksByStudent(Long studentId) {
        Student student = new Student();
        student.setId(studentId);
        return new ArrayList<>(courseWorkRepository.findByStudent(student));
    }
}
