package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.User;
import by.bsuir.ceres.service.SecurityService;
import by.bsuir.ceres.service.UserService;
import by.bsuir.ceres.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(@ModelAttribute User userForm,
                                     ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView("registrationTemplate");
        if (userForm == null) {
            userForm = new User();
        }
        modelAndView.addObject("userForm", userForm);
        modelAndView.addObject(BindingResult.MODEL_KEY_PREFIX + "userForm", modelMap.get("error"));
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm,
                               BindingResult bindingResult,
                               Model model,
                               RedirectAttributes attributes) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            attributes.addFlashAttribute("error", bindingResult);
            attributes.addFlashAttribute("userForm", userForm);
            return "redirect:/registration";
        }

        userService.createUser(userForm);

        securityService.autologin(userForm.getEmail(), userForm.getPasswordConfirm());

        return "redirect:/index";
    }
}
