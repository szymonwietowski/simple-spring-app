package com.wietos.simple.controllers;

import com.wietos.simple.model.Person;
import com.wietos.simple.repository.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public String personForm(Model model) {
        model.addAttribute("person", new Person());
        return "personForm";
    }

    @PostMapping("/save")
    public String savePerson(@ModelAttribute Person person, Model model) {
        Person saved = personRepository.save(person);
        model.addAttribute("savedPerson", saved.getId());
        return "personForm";
    }
}
