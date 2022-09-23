package com.example.application.entity;

import com.example.application.converter.StringToPostConverter;
import com.example.application.dto.CommentDTO;
import com.example.application.dto.PostDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name="post_id", nullable=false)
    private Post post;

    public Comment(){}
    public Comment(CommentDTO dto, PostDTO postDto){
        if(dto.getId() != 0) this.id = dto.getId();
        this.content = dto.getContent();
        this.post = new Post(postDto);
    }
}
