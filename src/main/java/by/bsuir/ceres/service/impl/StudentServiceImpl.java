package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.Student;
import by.bsuir.ceres.dao.StudentRepository;
import by.bsuir.ceres.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {

        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {

        return studentRepository.findOne(id);
    }

    @Override
    public void createStudent(Student student) {

        studentRepository.save(student);
    }

    @Override
    public void updateStudentById(Student student) {

        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {

        studentRepository.delete(id);
    }
}
