package com.ru.automatizado.ruautomatizado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ru.automatizado.ruautomatizado.model.Funcionario;


public interface Funcionarios extends JpaRepository<Funcionario, String>{
	
	public List<Funcionario> findByMatriculaContaining(String matricula);
	
	
}