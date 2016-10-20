package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.News;

import java.util.List;

public interface NewsService {

    List<News> getAllNews();
    News getNewsById(Long id);
    void createNews(News news);
    void updateNewsById(News news);
    void deleteNewsById(Long id);
}
