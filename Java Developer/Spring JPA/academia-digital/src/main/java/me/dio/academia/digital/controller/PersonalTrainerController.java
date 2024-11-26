package me.dio.academia.digital.controller;

import jakarta.validation.Valid;
import me.dio.academia.digital.entity.PersonalTrainer;
import me.dio.academia.digital.entity.form.PersonalTrainerForm;
import me.dio.academia.digital.service.impl.PersonalTrainerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personal")
public class PersonalTrainerController {

    @Autowired
    PersonalTrainerServiceImpl personalTrainerService;

    @PostMapping
    public PersonalTrainer create(@Valid @RequestBody PersonalTrainerForm personal){
        return personalTrainerService.create(personal);
    }

    @GetMapping
    public List<PersonalTrainer> getAll(){
        return personalTrainerService.getAll();
    }

    @GetMapping("/{id}")
    public PersonalTrainer getById(@PathVariable Long id){
        return personalTrainerService.get(id);
    }
}
