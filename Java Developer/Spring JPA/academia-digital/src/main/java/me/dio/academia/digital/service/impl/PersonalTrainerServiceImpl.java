package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.PersonalTrainer;
import me.dio.academia.digital.entity.form.PersonalTrainerForm;
import me.dio.academia.digital.repository.PersonalTrainerRepository;
import me.dio.academia.digital.service.IPersonalTrainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalTrainerServiceImpl implements IPersonalTrainer {

    @Autowired
    PersonalTrainerRepository personalTrainerRepository;

    @Override
    public PersonalTrainer create(PersonalTrainerForm personal) {
        PersonalTrainer personalTrainer = new PersonalTrainer();
        personalTrainer.setNome(personal.getNome());
        personalTrainer.setSobrenome(personal.getSobrenome());
        personalTrainer.setDataDeNascimento(personal.getDataDeNascimento());
        personalTrainer.setContratadoDaAcademia(personal.getContratadoDaAcademia());
        personalTrainer.setSexo(personal.getSexo());
        personalTrainerRepository.save(personalTrainer);
        return personalTrainer;
    }

    @Override
    public PersonalTrainer get(Long id) {
        return personalTrainerRepository.findById(id).get();
    }

    @Override
    public List<PersonalTrainer> getAll() {
        return personalTrainerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Optional<PersonalTrainer> personalTrainer = personalTrainerRepository.findById(id);
        personalTrainer.ifPresent(trainer -> personalTrainerRepository.delete(trainer));
    }
}
