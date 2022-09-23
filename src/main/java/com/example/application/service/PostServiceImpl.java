package com.example.application.service;

import com.example.application.dto.PostDTO;
import com.example.application.entity.Post;
import com.example.application.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Set<PostDTO> findAll(){
        return StreamSupport.stream(postRepository.findAll().spliterator(), false)
                .map(PostDTO::new).collect(Collectors.toSet());
    }

    @Override
    public PostDTO findById(long id) {
        return new PostDTO(postRepository.findById(id).orElse(null));
    }

    @Override
    public void save(PostDTO postDTO) {
        postRepository.save(new Post(postDTO));
    }

    @Override
    public void deleteById(long id) {
        postRepository.deleteById(id);
    }
}
