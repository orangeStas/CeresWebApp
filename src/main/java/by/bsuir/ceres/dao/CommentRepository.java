package by.bsuir.ceres.dao;

import by.bsuir.ceres.bean.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kirilltsivako on 5/24/17.
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
