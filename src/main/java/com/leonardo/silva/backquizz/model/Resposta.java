package com.leonardo.silva.backquizz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter @Setter
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "resposta")
public class Resposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_RESPOSTA")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "CD_QUIZZ", referencedColumnName = "CD_QUIZZ")
	private Quizz quizz;
	
	@ManyToOne
	@JoinColumn(name = "CD_PERGUNTA", referencedColumnName = "CD_PERGUNTA")
	private Pergunta pergunta;
	
	@Column(name = "DS_RESPOSTA")
	private String drescricao;
	
	@Column(name = "SN_CORRETA")
	private Integer correta;
	
}
