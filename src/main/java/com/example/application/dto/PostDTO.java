package com.example.application.dto;

import com.example.application.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class PostDTO {
    private long id;
    private String title;
    private String content;
    private String imagePath;
    private Set<TagDTO> tags = Set.of();
    private Set<CommentDTO> comments = Set.of();
    public PostDTO(){
    }
    public PostDTO(Post post) {
        if(post == null) return;
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.imagePath = post.getImagePath();
        this.tags = post.getTags().stream().map(TagDTO::new).collect(Collectors.toSet());
        this.comments = post.getComments().stream().map(CommentDTO::new).collect(Collectors.toSet());
    }
}
