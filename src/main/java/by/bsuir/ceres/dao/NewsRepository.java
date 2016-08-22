package by.bsuir.ceres.dao;

import by.bsuir.ceres.bean.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Long> {
}
