package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.News;
import by.bsuir.ceres.dao.NewsRepository;
import by.bsuir.ceres.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public News getNewsById(Long id) {

        return newsRepository.findOne(id);
    }

    @Override
    public void createNews(News news) {

        newsRepository.save(news);
    }

    @Override
    public void updateNewsById(News news) {

        newsRepository.save(news);
    }

    @Override
    public void deleteNewsById(Long id) {

        newsRepository.delete(id);
    }

    @Override
    public List<News> getAllNews() {

        return (List<News>) newsRepository.findAll();
    }
}
