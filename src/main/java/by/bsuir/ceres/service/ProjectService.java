package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.Project;

public interface ProjectService {
    Project createProject(Project project);
    Project loadById(Long id);
}
