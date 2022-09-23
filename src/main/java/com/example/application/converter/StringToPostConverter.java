package com.example.application.converter;

import com.example.application.dto.PostDTO;
import com.example.application.service.PostService;
import com.example.application.utils.StringRepresentation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StringToPostConverter implements Converter<String, PostDTO> {
    @Resource
    private PostService postService;

    @Override
    public PostDTO convert(String source) {
        if (source.equals(StringRepresentation.NULL)) return null;
        try {
            return postService.findById(Long.parseLong(source));
        } catch (Exception e) {
            throw new RuntimeException("could not convert `" + source + "` to an valid post");
        }
    }
}
