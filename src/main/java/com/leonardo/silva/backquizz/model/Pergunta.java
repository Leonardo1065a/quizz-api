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
@Table(name = "pergunta")
public class Pergunta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_PERGUNTA")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "CD_QUIZZ", referencedColumnName = "CD_QUIZZ")
	private Quizz quizz;
	
	@Column(name = "DS_PERGUNTA")
	private String drescricao;

}
