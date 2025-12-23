package dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dto.Comment;
import dto.Task;
import repo.CommentRepo;


@Repository
public class CommentDao {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    TaskDao taskDao;

   
    public Comment addCommentToTask(int taskId, Comment comment) {
        Task task = taskDao.fetchTaskById(taskId);
        task.getComments().add(comment);
        taskDao.saveTask(task);
        return comment;
    }

    
    public Comment fetchCommentById(int commentId) {
        return commentRepo.findById(commentId).get();
    }

    
    public Comment deleteCommentById(int commentId) {
        Comment comment = fetchCommentById(commentId);
        commentRepo.delete(comment);
        return comment;
    }

}

