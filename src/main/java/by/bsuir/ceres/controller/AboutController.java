package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.Menu;
import by.bsuir.ceres.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class AboutController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/about-us")
    public ModelAndView aboutPage(@ModelAttribute ("topMenu")ArrayList<Menu> topMenu) {
        ModelAndView modelAndView = new ModelAndView("aboutTemplate");
        topMenu = (ArrayList<Menu>) menuService.getTopMenu();
        modelAndView.addObject("topMenu", topMenu);

        return modelAndView;
    }
}
