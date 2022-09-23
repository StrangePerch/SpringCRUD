package com.example.application.controller;

import com.example.application.dto.TagDTO;
import com.example.application.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping("/tag")
    public String save(
            TagDTO dto
    ) {
        tagService.save(dto);
        return "redirect:/";
    }

    @PutMapping("/tag/{id}")
    public String update(
            @PathVariable long id,
            TagDTO dto
    ) {
        dto.setId(id);
        tagService.save(dto);
        return "redirect:/tag/" + id;
    }

    @GetMapping("/tag/{id}")
    public String details(
            Model model,
            @PathVariable long id
    ) {
        var tag = tagService.findById(id);
        model.addAttribute("tag", tag);
        return "tag/details";
    }

    @GetMapping("/tag/{id}/edit")
    public String edit(
            Model model,
            @PathVariable long id
    ) {
        var tag = tagService.findById(id);
        model.addAttribute("tag", tag);
        return "tag/edit";
    }

    @DeleteMapping("/tag/{id}")
    public String delete(
            @PathVariable long id
    ) {
        tagService.deleteById(id);
        return "redirect:/";
    }
}
