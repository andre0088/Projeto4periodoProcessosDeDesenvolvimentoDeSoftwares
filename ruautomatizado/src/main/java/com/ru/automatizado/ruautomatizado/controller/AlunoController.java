package com.ru.automatizado.ruautomatizado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ru.automatizado.ruautomatizado.model.Aluno;
import com.ru.automatizado.ruautomatizado.repository.AlunoFilter;
import com.ru.automatizado.ruautomatizado.repository.Alunos;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private Alunos alunosJPA;
	
	private static final String CADASTRO_VIEW = "TelaCadastroAluno";
	private static final String LISTAR_VIEW = "TelaListarAlunos";
	
	@RequestMapping("/cadastro")
	public ModelAndView telaCadastroAluno() {
		ModelAndView modelAndView = new ModelAndView(CADASTRO_VIEW);
		modelAndView.addObject(new Aluno());
		return modelAndView;
	}	
	
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") AlunoFilter filtro) {
		List<Aluno>todosAlunos; 
		String matricula = filtro.getMatricula() == null ? "%" : filtro.getMatricula();
		ModelAndView mv = new ModelAndView(LISTAR_VIEW);
		if(matricula.equals("%")) {
			todosAlunos = alunosJPA.findAll();
		}else {
			todosAlunos = alunosJPA.findByMatriculaContaining(matricula);
		}
		mv.addObject("allAlunos",todosAlunos);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String cadastrar(@Validated Aluno aluno, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		alunosJPA.save(aluno);
		attributes.addFlashAttribute("mensagem", "Operação Realizada Com Sucesso!");
		
		return "redirect:/aluno/cadastro";
	}
	
	
	@RequestMapping("{matricula}")
	public ModelAndView editar(@PathVariable("matricula")Aluno aluno) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(aluno);
		return mv;
	}
	
	@RequestMapping(value = "{matricula}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable String matricula) {
		alunosJPA.deleteById(matricula);
		return "redirect:/aluno";
	}
}
