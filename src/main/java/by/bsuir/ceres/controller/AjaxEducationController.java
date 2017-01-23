package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.education.Faculty;
import by.bsuir.ceres.bean.education.University;
import by.bsuir.ceres.service.FacultyService;
import by.bsuir.ceres.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest-education")
public class AjaxEducationController {

    @Autowired
    private UniversityService universityService;

    @Autowired
    private FacultyService facultyService;

    @RequestMapping(value = "/university/all")
    @ResponseBody
    public List<University> getAllUnivers() {
        List<University> universities = universityService.getAllUniversities();
        return universities;
    }

    @RequestMapping(value = "/university/faculties/{univerId}")
    @ResponseBody
    public List<Faculty> getFacultiesByUniversity(@PathVariable Long univerId) {
        return facultyService.getFacultiesByUniversity(univerId);
    }

}
