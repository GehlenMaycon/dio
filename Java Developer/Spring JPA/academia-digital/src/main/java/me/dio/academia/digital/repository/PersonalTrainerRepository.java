package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.PersonalTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalTrainerRepository extends JpaRepository<PersonalTrainer, Long> {

    List<PersonalTrainer> findBySexo(Character sexo);

}
