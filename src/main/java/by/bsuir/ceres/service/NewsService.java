package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.News;
import by.bsuir.ceres.dao.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements INewsService {

    @Autowired
    NewsRepository newsRepository;

    @Override
    public News getNewsById(Long id) {
        return newsRepository.findOne(id);
    }

    @Override
    public List<News> getAllNews() {
        return (List<News>) newsRepository.findAll();
    }
}
