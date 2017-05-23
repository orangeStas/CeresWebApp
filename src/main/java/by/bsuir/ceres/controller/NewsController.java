package by.bsuir.ceres.controller;

import by.bsuir.ceres.bean.Comment;
import by.bsuir.ceres.bean.Menu;
import by.bsuir.ceres.bean.News;
import by.bsuir.ceres.service.CommentService;
import by.bsuir.ceres.service.MenuService;
import by.bsuir.ceres.service.NewsService;
import by.bsuir.ceres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/news")
    public ModelAndView getAllNews(@ModelAttribute("newsList")ArrayList<News> newsList) {

        ModelAndView modelAndView = new ModelAndView("newsTemplate");
        ArrayList<News> newses = (ArrayList<News>) newsService.getAllNews();
        modelAndView.addObject("newsList", newses);
        return modelAndView;
    }

    @RequestMapping("/news/{newsId}")
    public ModelAndView getNewsById(@PathVariable long newsId,
                                    @ModelAttribute("news") News news) {

        ModelAndView modelAndView = new ModelAndView("singleNewsTemplate");
        news = newsService.getNewsById(newsId);
        modelAndView.addObject("news", news);
        return modelAndView;
    }

    @RequestMapping(value = "/news/addComment", method = RequestMethod.POST)
    public String addComment(HttpServletRequest request) {
        String content = request.getParameter("comment_text");
        Long newsId = Long.valueOf(request.getParameter("news_id"));

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        by.bsuir.ceres.bean.User user1 = userService.findByEmail(user.getUsername());

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setAuthor(user1.getStudent());
        comment.setDatetime(new Timestamp(new Date().getTime()));

        commentService.createComment(comment);

        News news = newsService.getNewsById(newsId);
        List<Comment> comments = news.getComments();
        comments.add(comment);
        news.setComments(comments);

        newsService.updateNewsById(news);

        return "redirect:/news/" + newsId;
    }
}