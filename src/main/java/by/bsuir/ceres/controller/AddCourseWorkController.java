package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.CourseWork;
import by.bsuir.ceres.bean.Menu;
import by.bsuir.ceres.service.CourseWorkService;
import by.bsuir.ceres.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

/**
 * Created by wowru on 11/20/2016.
 */
@Controller
@RequestMapping("/education")
public class AddCourseWorkController {

    @Autowired
    private CourseWorkService courseWorkService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/addCourseWork")
    public ModelAndView getAddCourseWorkPage(@ModelAttribute("courseWork")CourseWork courseWork,
                                             @ModelAttribute("topMenu")ArrayList<Menu> topMenu){

        ModelAndView modelAndView = new ModelAndView("addCourseWorkTemplate");

        courseWork = new CourseWork();

        topMenu = (ArrayList<Menu>) menuService.getTopMenu();
        modelAndView.addObject("courseWork", courseWork);
        modelAndView.addObject("topMenu", topMenu);

        return modelAndView;
    }

    @RequestMapping(value = "/addWork", method = RequestMethod.POST)
    public String addWork(@ModelAttribute("courseWork")CourseWork courseWork,
                          BindingResult bindingResult,
                          RedirectAttributes attributes) {

        if (bindingResult.hasErrors()) {

            attributes.addFlashAttribute("error", bindingResult);
            attributes.addFlashAttribute("courseWork", courseWork);
            return "redirect:/education/addCourseWork";
        }

        courseWorkService.createCourseWork(courseWork);

        return "redirect:../";
    }
}
