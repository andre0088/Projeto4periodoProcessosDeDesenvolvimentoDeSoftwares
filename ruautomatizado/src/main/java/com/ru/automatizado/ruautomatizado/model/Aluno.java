package com.ru.automatizado.ruautomatizado.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Aluno {

	@Id
	@NotEmpty(message = "Por Favor Informe A Matrícula")
	private String matricula;
	
	@NotEmpty(message = "Por Favor Informe O CPF")
	private String cpf;
	
	@NotEmpty(message = "Por Favor Informe O Nome")
	private String nome;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
