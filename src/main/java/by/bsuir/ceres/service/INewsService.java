package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.News;

import java.util.List;

public interface INewsService {
    List<News> getAllNews();
    News getNewsById(Long id);
}
