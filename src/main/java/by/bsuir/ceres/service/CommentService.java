package by.bsuir.ceres.service;

import by.bsuir.ceres.bean.Comment;

import java.util.List;

/**
 * Created by kirilltsivako on 5/24/17.
 */
public interface CommentService {

    List<Comment> getAllComments();
    Comment getComment(Long id);
    void createComment(Comment comment);
    void updateComment(Comment comment);
    void deleteCommentById(Long id);
}
