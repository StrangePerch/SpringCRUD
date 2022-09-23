package com.example.application.service;

import com.example.application.dto.PostDTO;

import java.util.Set;

public interface PostService {
    Set<PostDTO> findAll();
    PostDTO findById(long id);
    void save(PostDTO postDTO);
    void deleteById(long id);
}
