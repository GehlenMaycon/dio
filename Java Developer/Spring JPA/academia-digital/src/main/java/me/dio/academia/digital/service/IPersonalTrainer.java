package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.PersonalTrainer;
import me.dio.academia.digital.entity.form.PersonalTrainerForm;

import java.util.List;

public interface IPersonalTrainer {

    PersonalTrainer create(PersonalTrainerForm personalTrainerForm);

    PersonalTrainer get(Long id);

    List<PersonalTrainer> getAll();

    void delete(Long id);
}
