package com.example.application.service;

import com.example.application.dto.CommentDTO;
import com.example.application.dto.PostDTO;
import com.example.application.entity.Comment;
import com.example.application.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void save(CommentDTO dto, PostDTO postDTO) {
        commentRepository.save(new Comment(dto, postDTO));
    }

    @Override
    public Set<CommentDTO> findAll() {
        return StreamSupport.stream(commentRepository.findAll().spliterator(), false)
                .map(CommentDTO::new).collect(Collectors.toSet());
    }
}
