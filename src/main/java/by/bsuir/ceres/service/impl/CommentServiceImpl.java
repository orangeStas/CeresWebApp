package by.bsuir.ceres.service.impl;

import by.bsuir.ceres.bean.Comment;
import by.bsuir.ceres.dao.CommentRepository;
import by.bsuir.ceres.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kirilltsivako on 5/24/17.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public Comment getComment(Long id) {
        return commentRepository.findOne(id);
    }

    @Override
    public void createComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentRepository.delete(id);
    }
}
