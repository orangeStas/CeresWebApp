package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.Project;
import by.bsuir.ceres.bean.Student;
import by.bsuir.ceres.bean.User;
import by.bsuir.ceres.dao.ProjectRepository;
import by.bsuir.ceres.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project loadById(Long id) {
        return projectRepository.findOne(id);
    }

    @Override
    public List<Project> getProjectsByStudent(Long studentId) {
        Student student = new Student();
        student.setId(studentId);
        return new ArrayList<>(projectRepository.findByAuthor(student));
    }
}
