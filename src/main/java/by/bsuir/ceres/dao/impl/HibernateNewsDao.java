package by.bsuir.ceres.dao.impl;

import by.bsuir.ceres.bean.News;
import by.bsuir.ceres.dao.NewsDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateNewsDao implements NewsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(News object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public News read(Long key) {
        return sessionFactory.getCurrentSession().get(News.class, key);
    }

    @Override
    public void update(News object) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(object);
        session.flush();
    }

    @Override
    public void delete(Long key) {
        Session session = sessionFactory.getCurrentSession();
        News news = new News();
        news.setId(key);
        session.delete(news);
        session.flush();
    }
}
