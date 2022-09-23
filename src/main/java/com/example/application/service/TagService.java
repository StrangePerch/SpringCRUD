package com.example.application.service;

import com.example.application.dto.TagDTO;

import java.util.Set;

public interface TagService {
    Set<TagDTO> findAll();
    TagDTO findById(long id);
    void save(TagDTO tagDTO);
    void deleteById(long id);
}
