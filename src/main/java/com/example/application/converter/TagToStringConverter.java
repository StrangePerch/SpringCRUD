package com.example.application.converter;

import com.example.application.dto.TagDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class TagToStringConverter implements Converter<TagDTO, java.lang.String> {

    @Override
    public String convert(TagDTO tag) {
        try {
            return String.valueOf(tag.getId());
        } catch (NumberFormatException e) {
            throw new RuntimeException("could not convert `" + tag + "` to an valid id");
        }
    }
}
