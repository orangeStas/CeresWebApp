package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.ProjectStatus;
import by.bsuir.ceres.dao.ProjectStatusRepository;
import by.bsuir.ceres.service.ProjectStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectStatusServiceImpl implements ProjectStatusService {

    @Autowired
    private ProjectStatusRepository projectStatusRepository;

    @Override
    public void addStatus(ProjectStatus projectStatus) {
        projectStatusRepository.save(projectStatus);
    }
}
