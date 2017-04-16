package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.*;
import by.bsuir.ceres.service.CourseWorkService;
import by.bsuir.ceres.service.MenuService;
import by.bsuir.ceres.service.ProjectService;
import by.bsuir.ceres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wowru on 4/15/2017.
 */
@Controller
@RequestMapping("/education/profile")
public class ProfileController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    MenuService menuService;

    @RequestMapping(value = "/{profileId}")
    public ModelAndView openProfile(@PathVariable("profileId")Long profileId) {
        ModelAndView modelAndView = new ModelAndView("profileTemplate");

        User user = userService.getUserById(profileId);
        Student student = user.getStudent();

        List<Project> projects = projectService.getProjectsByStudent(student.getId());

        modelAndView.addObject("student", student);
        modelAndView.addObject("projects", projects);

        return modelAndView;
    }
}
