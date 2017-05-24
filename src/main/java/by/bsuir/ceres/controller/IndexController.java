package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.Menu;
import by.bsuir.ceres.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by wowrumal on 11/1/2016.
 */
@Controller
public class IndexController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/index")
    public ModelAndView getIndexPage(@ModelAttribute("topMenu") ArrayList<Menu> topMenu,
                                     HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("indexTemplate");
        request.getSession().setAttribute("menu", menuService.getTopMenu());

        return modelAndView;
    }

    @RequestMapping(value = "/404")
    public ModelAndView errorPage() {
        ModelAndView modelAndView = new ModelAndView("errorTemplate");
        String errorCode;
        String messageFirstPart;
        String messageSecondPart;
        errorCode = "404";
        messageFirstPart = "СТРАНИЦА";
        messageSecondPart = "НЕ НАЙДЕНА";
        modelAndView.addObject("errorCode", errorCode);
        modelAndView.addObject("messageFirstPart", messageFirstPart);
        modelAndView.addObject("messageSecondPart", messageSecondPart);
        return modelAndView;
    }
}
