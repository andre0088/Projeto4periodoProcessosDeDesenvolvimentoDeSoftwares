package com.ru.automatizado.ruautomatizado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ru.automatizado.ruautomatizado.model.Aluno;

public interface Alunos extends JpaRepository<Aluno, String>{
	
	public List<Aluno> findByMatriculaContaining(String matricula);
	
}
