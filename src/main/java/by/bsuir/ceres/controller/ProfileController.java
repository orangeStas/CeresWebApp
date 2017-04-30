package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.Project;
import by.bsuir.ceres.bean.Student;
import by.bsuir.ceres.bean.User;
import by.bsuir.ceres.service.MenuService;
import by.bsuir.ceres.service.ProjectService;
import by.bsuir.ceres.service.StudentService;
import by.bsuir.ceres.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/education/profile")
public class ProfileController {

    private static final String PATH = "files/";

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

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

    @RequestMapping(value = "/changeImage", method = RequestMethod.POST)
    public String changeImage(@RequestParam("sourceFile")MultipartFile multipartFile) {

        if (!multipartFile.getOriginalFilename().isEmpty()) {
            User user = null;
            org.springframework.security.core.userdetails.User sessionUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            user = userService.findByEmail(sessionUser.getUsername());

            String imageFileName = UUID.randomUUID() + ".jpg";

            Student student = user.getStudent();
            student.setImageName(imageFileName);

            studentService.updateStudentById(student);

            try {
                byte[] bytes = multipartFile.getBytes();
                Path path = Paths.get(PATH + imageFileName);
                if (!Files.exists(Paths.get(PATH))) {
                    Files.createDirectory(Paths.get(PATH));
                }
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:../profile/-1";
    }
}
