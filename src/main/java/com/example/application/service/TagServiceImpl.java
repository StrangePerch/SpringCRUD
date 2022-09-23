package com.example.application.service;

import com.example.application.entity.Tag;
import com.example.application.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Set<com.example.application.dto.TagDTO> findAll(){
        return StreamSupport.stream(tagRepository.findAll().spliterator(), false)
                .map(com.example.application.dto.TagDTO::new).collect(Collectors.toSet());
    }

    @Override
    public com.example.application.dto.TagDTO findById(long id) {
        return new com.example.application.dto.TagDTO(tagRepository.findById(id).orElse(null));
    }

    @Override
    public void save(com.example.application.dto.TagDTO tagDTO) {
        tagRepository.save(new Tag(tagDTO));
    }

    @Override
    public void deleteById(long id) {
        tagRepository.deleteById(id);
    }
}
