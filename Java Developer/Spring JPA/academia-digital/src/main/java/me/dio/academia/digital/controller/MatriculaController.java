package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    MatriculaServiceImpl matriculaService;

    @GetMapping
    public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro){
        return matriculaService.getAll(bairro);
    }
}
