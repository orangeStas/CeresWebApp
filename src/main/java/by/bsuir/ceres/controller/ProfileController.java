package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.Project;
import by.bsuir.ceres.bean.Student;
import by.bsuir.ceres.bean.User;
import by.bsuir.ceres.service.MenuService;
import by.bsuir.ceres.service.ProjectService;
import by.bsuir.ceres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

        User user = null;
        Student student = null;

        if (profileId == -1) {
            org.springframework.security.core.userdetails.User sessionUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            user = userService.findByEmail(sessionUser.getUsername());
            student = user.getStudent();
        } else {
            user = userService.getUserById(profileId);
            student = user.getStudent();
        }

        List<Project> projects = projectService.getProjectsByStudent(student.getId());

        modelAndView.addObject("student", student);
        modelAndView.addObject("projects", projects);

        return modelAndView;
    }
}
