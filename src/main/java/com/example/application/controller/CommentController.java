package com.example.application.controller;

import com.example.application.dto.CommentDTO;
import com.example.application.service.CommentService;
import com.example.application.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;

    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @PostMapping("/comment/{postId}")
    public String save(
            CommentDTO dto,
            @PathVariable long postId
    ) {
        var post = postService.findById(postId);
        commentService.save(dto, post);
        return "redirect:/post/" + post.getId();
    }
}
