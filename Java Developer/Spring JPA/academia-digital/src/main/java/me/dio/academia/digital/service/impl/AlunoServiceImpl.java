package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        return null;
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {
        if(dataDeNascimento == null){
            return alunoRepository.findAll();
        }
        LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
        return alunoRepository.findByDataDeNascimento(localDate);
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        aluno.isPresent();
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    public List<AvaliacaoFisica> getAllAvaliacaoFisica(Long id) {
        Aluno aluno = alunoRepository.findById(id).get();
        return aluno.getAvaliacoes();
    }
}
