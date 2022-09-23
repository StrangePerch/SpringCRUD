package com.example.application.converter;

import com.example.application.dto.TagDTO;
import com.example.application.service.TagService;
import com.example.application.utils.StringRepresentation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StringToTagConverter implements Converter<String, TagDTO> {
    @Resource
    private TagService tagService;

    @Override
    public TagDTO convert(String source) {
        if(source.equals(StringRepresentation.NULL)) return null;
        try{
            return tagService.findById(Long.parseLong(source));
        } catch (Exception e) {
            throw new RuntimeException("could not convert `" + source + "` to an valid tag");
        }
    }
}
