package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;


import dto.Comment;
import service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Operation(summary = "Add Comment", description = "User adds a comment to a task")
    @PostMapping("/task/{taskId}/add")
    public Comment addComment(@PathVariable int taskId, @RequestBody Comment comment,
            @RequestParam String currentRole) {
        return commentService.addComment(taskId, comment, currentRole);
    }
}

