package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.*;
import by.bsuir.ceres.service.ProjectService;
import by.bsuir.ceres.service.ProjectStatusService;
import by.bsuir.ceres.service.TagService;
import by.bsuir.ceres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/education/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private TagService tagService;

    @Autowired
    private ProjectStatusService projectStatusService;

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
        project.setChat(new Chat(){{setProject(project);}});
        Project project1 = projectService.createProject(project);
        return "redirect:/education/project/" + project1.getId();
    }

    @RequestMapping(value = "/{projectId}")
    public ModelAndView openProject(@PathVariable("projectId")Long projectId) {
        ModelAndView modelAndView = new ModelAndView("projectTemplate");
        Project project = projectService.loadById(projectId);

        List<ProjectStatus> projectStatusList = new ArrayList<>(project.getProjectStatuses());
        Collections.sort(projectStatusList, (s1, s2) -> (-1) * s1.getTime().compareTo(s2.getTime()));
        modelAndView.addObject("userInProject", isUserInProject(project));
        modelAndView.addObject("statuses", projectStatusList);

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

    @RequestMapping(value = "/addStatus", method = RequestMethod.POST)
    public String addStatus(HttpServletRequest request) {
        String status = request.getParameter("status_text");
        Long projectId = Long.valueOf(request.getParameter("project_id"));
        Project project = new Project();
        project.setId(projectId);
        ProjectStatus projectStatus = new ProjectStatus();
        projectStatus.setProject(project);
        projectStatus.setStatus(status);
        projectStatus.setTime(new Timestamp(new Date().getTime()));

        projectStatusService.addStatus(projectStatus);

        return "redirect:/education/project/" + projectId;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAllProjects() {
        List<Project> projects = projectService.getAll();

        projects.sort((p1, p2) -> p1.getId().compareTo(p2.getId()));

        ModelAndView modelAndView = new ModelAndView("allProjectsTemplate");

        modelAndView.addObject("projects", projects);

        return modelAndView;
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
