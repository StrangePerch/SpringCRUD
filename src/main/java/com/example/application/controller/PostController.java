package com.example.application.controller;

import com.example.application.dto.PostDTO;
import com.example.application.service.PostService;
import com.example.application.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostService postService;
    private final TagService tagService;

    public PostController(PostService postService, TagService tagService) {
        this.postService = postService;
        this.tagService = tagService;
    }

    @PostMapping("/post")
    public String save(
            PostDTO dto
    ) {
        postService.save(dto);
        return "redirect:/";
    }

    @PutMapping("/post/{id}")
    public String update(
            @PathVariable long id,
            PostDTO dto
    ) {
        dto.setId(id);
        postService.save(dto);
        return "redirect:/post/" + id;
    }

    @GetMapping("/post/{id}")
    public String details(
            Model model,
            @PathVariable String id
    ) {
        model.addAttribute("post", postService.findById(Long.parseLong(id)));
        return "post/details";
    }

    @GetMapping("/post/{id}/edit")
    public String edit(
            Model model,
            @PathVariable String id
    ) {
        model.addAttribute("post", postService.findById(Long.parseLong(id)));
        model.addAttribute("tags", tagService.findAll());
        return "post/edit";
    }

    @DeleteMapping("/post/{id}")
    public String delete(
            @PathVariable long id
    ) {
        postService.deleteById(id);
        return "redirect:/";
    }
}
