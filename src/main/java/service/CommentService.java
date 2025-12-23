package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CommentDao;
import dto.Comment;
import exception.UnauthorizedException;


@Service
public class CommentService {

    @Autowired
    CommentDao commentDao;

    
    public Comment addComment(int taskId, Comment comment, String currentRole) {
        if (!currentRole.equals("USER")) {
            throw new UnauthorizedException("Only Users can add comments");
        }
        return commentDao.addCommentToTask(taskId, comment);
    }

}

