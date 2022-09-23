package com.example.application.dto;

import com.example.application.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
    private long id;
    private String content;
    private long postId;

    public CommentDTO(Comment comment) {
        if(comment == null) return;
        id = comment.getId();
        content = comment.getContent();
        postId = comment.getPost().getId();
    }
}
