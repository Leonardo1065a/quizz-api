package com.leonardo.silva.backquizz.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.silva.backquizz.model.Quizz;
import com.leonardo.silva.backquizz.repository.QuizzRepository;

@Service
public class QuizzBusiness {

	@Autowired
	private QuizzRepository repository;
	
	public List<Quizz> getAll(){
		return this.repository.findAll();
	}
	
	public Quizz getById(Long id) {
		return this.repository.findOne(id);
	}
	
	public Quizz saveOrUpdate(Quizz quizz) throws Exception{
		try {
			return this.repository.save(quizz);
		} catch (Exception e) {
			throw new Exception("Erro ao salvar", e);
		}
	}
	
	public void delete(Long id) {
		this.repository.delete(id);
	}
	
}
