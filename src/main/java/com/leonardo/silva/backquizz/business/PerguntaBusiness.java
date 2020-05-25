package com.leonardo.silva.backquizz.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.silva.backquizz.model.Pergunta;
import com.leonardo.silva.backquizz.repository.PerguntaRepository;

@Service
public class PerguntaBusiness {

	@Autowired
	private PerguntaRepository repository;
	
	public List<Pergunta> getAll(){
		return this.repository.findAll();
	}
	
	public Pergunta getById(Long id) {
		return this.repository.findOne(id);
	}
	
	public Pergunta saveOrUpdate(Pergunta pergunta) throws Exception{
		try {
			return this.repository.save(pergunta);
		} catch (Exception e) {
			throw new Exception("Erro ao salvar", e);
		}
	}
	
	public void delete(Long id) {
		this.repository.delete(id);
	}
}
