package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.Menu;
import by.bsuir.ceres.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by wowrumal on 11/1/2016.
 */
public class IndexController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/")
    public ModelAndView getIndexPage(@ModelAttribute("topMenu")ArrayList<Menu> topMenu) {

        ModelAndView modelAndView = new ModelAndView("indexTemplate");

        topMenu = (ArrayList<Menu>) menuService.getTopMenu();
        modelAndView.addObject("topMenu", topMenu);

        return modelAndView;
    }
}
