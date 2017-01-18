package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.education.University;
import by.bsuir.ceres.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest-education")
public class AjaxEducationController {

    @Autowired
    private UniversityService universityService;

    @RequestMapping(value = "/university/all")
    @ResponseBody
    public List<University> getAllUnivers() {
        List<University> universities = universityService.getAllUniversities();
        return universities;
    }

}
