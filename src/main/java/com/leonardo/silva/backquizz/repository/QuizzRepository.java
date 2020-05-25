package com.leonardo.silva.backquizz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leonardo.silva.backquizz.model.Quizz;

@Repository
public interface QuizzRepository extends JpaRepository<Quizz, Long>{

}
