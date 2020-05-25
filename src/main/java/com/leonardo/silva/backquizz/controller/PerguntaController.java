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

import com.leonardo.silva.backquizz.business.PerguntaBusiness;
import com.leonardo.silva.backquizz.model.Pergunta;

@RestController
@RequestMapping(value = "perguntas")
public class PerguntaController {
	
	private @Autowired PerguntaBusiness business;
	
	@GetMapping
	public ResponseEntity<List<Pergunta>> list(){
		return ResponseEntity.ok(this.business.getAll());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Pergunta> findById(@PathVariable("id") Long id){
		Pergunta pergunta = this.business.getById(id);
		return pergunta != null ? ResponseEntity.ok(pergunta) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();			
	}
	
	@PostMapping
	public ResponseEntity<Pergunta> save(@RequestBody Pergunta pergunta) throws Exception{
		Boolean isSave = pergunta.getId() != null ? true : false; 
		Pergunta perguntaSalva = this.business.saveOrUpdate(pergunta);
		return isSave ? ResponseEntity.status(HttpStatus.OK).body(perguntaSalva) : 
			ResponseEntity.status(HttpStatus.CREATED).body(perguntaSalva);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		this.business.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
