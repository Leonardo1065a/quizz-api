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

import com.leonardo.silva.backquizz.business.RespostaBusiness;
import com.leonardo.silva.backquizz.model.Resposta;

@RestController
@RequestMapping(value = "respostas")
public class RespostaController {
	
	@Autowired
	private RespostaBusiness business;
	
	@GetMapping
	public ResponseEntity<List<Resposta>> list(){
		return ResponseEntity.ok(this.business.getAll());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Resposta> findById(@PathVariable("id") Long id){
		Resposta resposta = this.business.getById(id);
		return resposta != null ? ResponseEntity.ok(resposta) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();			
	}
	
	@PostMapping
	public ResponseEntity<Resposta> save(@RequestBody Resposta resposta) throws Exception{
		Boolean isSave = resposta.getId() != null ? true : false; 
		Resposta respostaSalva = this.business.saveOrUpdate(resposta);
		return isSave ? ResponseEntity.status(HttpStatus.OK).body(respostaSalva) : 
			ResponseEntity.status(HttpStatus.CREATED).body(respostaSalva);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		this.business.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
