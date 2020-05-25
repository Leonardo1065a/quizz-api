package com.leonardo.silva.backquizz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter @Setter
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "quizz")
public class Quizz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_QUIZZ")
	private Long id;
	
	@Column(name = "NM_QUIZZ")
	private String nome;
	
	@Column(name = "DS_QUIZZ")
	private String drescricao;

}
