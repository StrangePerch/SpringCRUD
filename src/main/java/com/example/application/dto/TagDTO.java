package com.example.application.dto;

import com.example.application.entity.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Getter
@Setter
public class TagDTO {
    private long id;
    private String name;

    public TagDTO(Tag tag) {
        if(tag == null) return;
        this.id = tag.getId();
        this.name = tag.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagDTO tagDTO = (TagDTO) o;
        return id == tagDTO.id && Objects.equals(name, tagDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
