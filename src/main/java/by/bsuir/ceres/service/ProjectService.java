package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.Project;

import java.util.List;

public interface ProjectService {
    Project createProject(Project project);
    Project loadById(Long id);
    List<Project> getProjectsByStudent(Long studentId);

    List<Project> getAll();
}
