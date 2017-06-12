package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.Student;
import by.bsuir.ceres.bean.TO.RegistrationTO;
import by.bsuir.ceres.bean.User;
import by.bsuir.ceres.service.SecurityService;
import by.bsuir.ceres.service.UniversityService;
import by.bsuir.ceres.service.UserService;
import by.bsuir.ceres.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UniversityService universityService;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(@ModelAttribute("registrationForm") RegistrationTO registrationForm, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView("registrationTemplate");
        if (registrationForm == null) {
            registrationForm = new RegistrationTO();
        }
        modelAndView.addObject("registrationForm", registrationForm);
        modelAndView.addObject("universities", universityService.getAllUniversities());
        modelAndView.addObject(BindingResult.MODEL_KEY_PREFIX + "registrationForm", modelMap.get("error"));
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login (Model model, String error, String logout,
                               HttpServletRequest request,
                               HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("loginTemplate");
        if (error != null) {
            modelAndView.addObject("error", "Неверное имя пользователя или пароль");
        }
        if (logout != null) {
            HttpSession session = request.getSession(false);
            SecurityContextHolder.clearContext();
            session = request.getSession();
            if (session != null) {
                session.invalidate();
            }
            for(Cookie cookie : request.getCookies()) {
                cookie.setMaxAge(0);
            }
            modelAndView.addObject("message", "You have been logged out successfully.");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("registrationForm") RegistrationTO registrationForm,
                               BindingResult bindingResult,
                               RedirectAttributes attributes) {

        User userForm = registrationForm.getUser();
        Student studentForm = registrationForm.getStudent();

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            attributes.addFlashAttribute("error", bindingResult);
            attributes.addFlashAttribute("registrationForm", registrationForm);
            return "redirect:/registration";
        }

        userForm.setStudent(studentForm);
        studentForm.setUser(userForm);
        userService.createUser(userForm);

        securityService.autologin(userForm.getMail(), userForm.getPasswordConfirm());

        return "redirect:/index";
    }
}
