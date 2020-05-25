package com.leonardo.silva.backquizz.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.silva.backquizz.model.Resposta;
import com.leonardo.silva.backquizz.repository.RespostaRepository;

@Service
public class RespostaBusiness {

	@Autowired
	private RespostaRepository repository;
	
	public List<Resposta> getAll(){
		return this.repository.findAll();
	}
	
	public Resposta getById(Long id) {
		return this.repository.findOne(id);
	}
	
	public Resposta saveOrUpdate(Resposta resposta) throws Exception{
		try {
			return this.repository.save(resposta);
		} catch (Exception e) {
			throw new Exception("Erro ao salvar", e);
		}
	}
	
	public void delete(Long id) {
		this.repository.delete(id);
	}
	
}
