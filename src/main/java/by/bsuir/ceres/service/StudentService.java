package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudentById(Long id);
    void createStudent(Student student);
    void updateStudentById(Student student);
    void deleteStudentById(Long id);
}
