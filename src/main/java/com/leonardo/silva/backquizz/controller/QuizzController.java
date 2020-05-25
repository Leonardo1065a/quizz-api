package com.leonardo.silva.backquizz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.silva.backquizz.business.QuizzBusiness;
import com.leonardo.silva.backquizz.model.Quizz;

@RestController
@RequestMapping(value = "quizzes")
public class QuizzController {
	
	@Autowired
	private QuizzBusiness business;
	
	@GetMapping
	public ResponseEntity<List<Quizz>> list(){
		return ResponseEntity.ok(this.business.getAll());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Quizz> findById(@PathVariable("id") Long id){
		Quizz quizz = this.business.getById(id);
		return quizz != null ? ResponseEntity.ok(quizz) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();			
	}
	
	@PostMapping
	public ResponseEntity<Quizz> save(@RequestBody Quizz quizz) throws Exception{
		Boolean isSave = quizz.getId() != null ? true : false; 
		Quizz quizzSalva = this.business.saveOrUpdate(quizz);
		return isSave ? ResponseEntity.status(HttpStatus.OK).body(quizzSalva) : 
			ResponseEntity.status(HttpStatus.CREATED).body(quizzSalva);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		this.business.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
