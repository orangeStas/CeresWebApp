package by.bsuir.ceres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EducationController {
    @RequestMapping(value = "/education")
    public ModelAndView openEducation() {
        ModelAndView modelAndView = new ModelAndView("eduTemplate");
        return modelAndView;
    }

}
