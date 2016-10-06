package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.News;
import by.bsuir.ceres.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private INewsService newsService;

    @RequestMapping("/allNews")
    public ModelAndView getAllNews(@ModelAttribute("newsList")List<News> newsList) {
        ModelAndView modelAndView = new ModelAndView("newsTemplate");
        List<News> newses = newsService.getAllNews();
        modelAndView.addObject("newsList", newses);

        return modelAndView;
    }

}
