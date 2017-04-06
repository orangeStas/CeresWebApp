package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.ProjectStatus;
import org.springframework.stereotype.Service;

@Service
public interface ProjectStatusService {

    void addStatus(ProjectStatus projectStatus);
}
