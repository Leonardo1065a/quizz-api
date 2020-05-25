package com.leonardo.silva.backquizz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leonardo.silva.backquizz.model.Resposta;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long>{

}
