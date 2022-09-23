package com.example.application.controller;

import com.example.application.dto.PostDTO;
import com.example.application.service.PostService;
import com.example.application.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final PostService postService;
    private final TagService tagService;

    public HomeController(PostService postService, TagService tagService) {
        this.postService = postService;
        this.tagService = tagService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postService.findAll());
        model.addAttribute("tags", tagService.findAll());
        model.addAttribute("newPost", new PostDTO());
        return "index";
    }
}
