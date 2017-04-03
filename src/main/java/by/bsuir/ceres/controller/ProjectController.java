package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.Chat;
import by.bsuir.ceres.bean.Project;
import by.bsuir.ceres.bean.Student;
import by.bsuir.ceres.bean.Tag;
import by.bsuir.ceres.service.ProjectService;
import by.bsuir.ceres.service.TagService;
import by.bsuir.ceres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/education/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private TagService tagService;

    @RequestMapping("/openCreateProject")
    public ModelAndView getCreateProjectPage(@ModelAttribute("project")Project project, @ModelAttribute("tags")ArrayList<Tag> tags) {
        ModelAndView modelAndView = new ModelAndView("createProjectTemplate");

        if (project != null) {
            project = new Project();
        }

        tags = (ArrayList<Tag>) tagService.getAll();

        modelAndView.addObject("project", project);
        modelAndView.addObject("tags", tags);

        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createProject(@ModelAttribute("project") Project project) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        by.bsuir.ceres.bean.User user1 = userService.findByEmail(user.getUsername());

        project.setAuthor(user1.getStudent());
        project.setChat(new Chat());
        Project project1 = projectService.createProject(project);
        return "redirect:/education/project/" + project1.getId();
    }

    @RequestMapping(value = "/{projectId}")
    public ModelAndView openProject(@PathVariable("projectId")Long projectId) {
        ModelAndView modelAndView = new ModelAndView("projectTemplate");
        Project project = projectService.loadById(projectId);

        modelAndView.addObject("userInProject", isUserInProject(project));

        modelAndView.addObject("project", project);
        return modelAndView;
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String joinToProject(@RequestParam(name = "projectId") Long projectId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        by.bsuir.ceres.bean.User user1 = userService.findByEmail(user.getUsername());
        Student student = user1.getStudent();

        Project project = projectService.loadById(projectId);
        project.getParticipants().add(student);

        projectService.createProject(project);

        return "redirect:/education/project/" + project.getId();
    }

    private boolean isUserInProject(Project project) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        by.bsuir.ceres.bean.User user1 = userService.findByEmail(user.getUsername());
        Student student = user1.getStudent();

        for (Student prSt : project.getParticipants()) {
            if (prSt.getId().equals(student.getId())) {
                return true;
            }
        }

        return student.getId().equals(project.getAuthor().getId());
    }
}
