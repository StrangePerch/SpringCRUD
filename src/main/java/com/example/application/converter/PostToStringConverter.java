package com.example.application.converter;

import com.example.application.dto.PostDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PostToStringConverter implements Converter<PostDTO, String> {

    @Override
    public String convert(com.example.application.dto.PostDTO post) {
        try {
            return String.valueOf(post.getId());
        } catch (NumberFormatException e) {
            throw new RuntimeException("could not convert `" + post + "` to an valid id");
        }
    }
}
