package com.example.application.service;


import com.example.application.dto.CommentDTO;
import com.example.application.dto.PostDTO;

import java.util.Set;

public interface CommentService {
    void save(CommentDTO dto, PostDTO postDTO);
    Set<CommentDTO> findAll();
}
