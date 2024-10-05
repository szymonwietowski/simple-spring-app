package com.wietos.simple.controllers;

import com.wietos.simple.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello(Model model) {
        model.addAttribute("message", "my mesasge");
        model.addAttribute("tasks", List.of("task1", "task2"));
        model.addAttribute("greeting", new Greeting());
        return "hello";
    }

    @PostMapping("/greeting")
    public String greeting(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("text", greeting.getContent());
        return "greeting";
    }
}
