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

import com.ru.automatizado.ruautomatizado.model.Funcionario;
import com.ru.automatizado.ruautomatizado.repository.FuncionarioFilter;
import com.ru.automatizado.ruautomatizado.repository.Funcionarios;
import com.ru.automatizado.ruautomatizado.security.MyUserDetailService;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private MyUserDetailService funcionarios;
	//Criei um repositório
	@Autowired
	private Funcionarios funcionariosJPA;
	
	private static final String CADASTRO_VIEW = "TelaCadastroFuncionario";
	private static final String LISTAR_VIEW = "TelaListarFuncionarios";
	
	@RequestMapping("/cadastro")
	public ModelAndView telaCadastroFuncionario() {
		ModelAndView modelAndView = new ModelAndView(CADASTRO_VIEW);
		modelAndView.addObject(new Funcionario());
		return modelAndView;
	}	
	
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") FuncionarioFilter filtro) {
		List<Funcionario>todosFuncionarios; 
		String matricula = filtro.getMatricula() == null ? "%" : filtro.getMatricula();
		ModelAndView mv = new ModelAndView(LISTAR_VIEW);
		if(matricula.equals("%")) {
			todosFuncionarios = funcionariosJPA.findAll();
		}else {
			todosFuncionarios = funcionariosJPA.findByMatriculaContaining(matricula);
		}
		mv.addObject("allFuncionarios",todosFuncionarios);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String cadastrar(@Validated Funcionario funcionario, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		if(!funcionario.getSenha().equals(funcionario.getConfSenha())) {
			attributes.addFlashAttribute("erro", "Confirme novamente sua senha");
		}else {
			funcionarios.save(funcionario);
			attributes.addFlashAttribute("mensagem", "Operação Realizada Com Sucesso!");
		}
		
		return "redirect:/funcionario/cadastro";
	}
	
	
	@RequestMapping("{matricula}")
	public ModelAndView editar(@PathVariable("matricula")Funcionario funcionario) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(funcionario);
		return mv;
	}
	
	@RequestMapping(value = "{matricula}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable String matricula) {
		funcionariosJPA.deleteById(matricula);
		return "redirect:/funcionario";
	}
}
