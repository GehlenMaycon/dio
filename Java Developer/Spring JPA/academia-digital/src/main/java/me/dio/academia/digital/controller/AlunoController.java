package me.dio.academia.digital.controller;

import jakarta.validation.Valid;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl alunoService;

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento){

        return alunoService.getAll(dataDeNascimento);
    }

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm aluno){
        return alunoService.create(aluno);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(@PathVariable Long id){
        return alunoService.getAllAvaliacaoFisica(id);
    }


}
