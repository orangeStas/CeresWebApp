package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.CourseWork;
import java.util.List;

/**
 * Created by wowru on 11/20/2016.
 */

public interface CourseWorkService {

    List<CourseWork> getAllCourseWorks();
    CourseWork getCourseWorkById(Long id);
    void createCourseWork(CourseWork courseWork);
    void updateCourseWorkById(CourseWork courseWork);
    void deleteCourseWorkById(Long id);
}
