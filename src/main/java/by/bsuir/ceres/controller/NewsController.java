package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.Menu;
import by.bsuir.ceres.bean.News;
import by.bsuir.ceres.service.MenuService;
import by.bsuir.ceres.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/allNews")
    public ModelAndView getAllNews(@ModelAttribute("newsList")ArrayList<News> newsList,
                                   @ModelAttribute("topMenu")ArrayList<Menu> topMenu) {

        ModelAndView modelAndView = new ModelAndView("newsTemplate");
        ArrayList<News> newses = (ArrayList<News>) newsService.getAllNews();
        modelAndView.addObject("newsList", newses);

        ArrayList<Menu> topMenus = (ArrayList<Menu>) menuService.getTopMenu();
        modelAndView.addObject("topMenu", topMenus);

        return modelAndView;
    }

    @RequestMapping("/news/{newsId}")
    public ModelAndView getNewsById(@PathVariable long newsId,
                                    @ModelAttribute("news") News news) {

        ModelAndView modelAndView = new ModelAndView("newsTemplate");
        news = newsService.getNewsById(newsId);
        modelAndView.addObject("news", news);

        return modelAndView;
    }
}