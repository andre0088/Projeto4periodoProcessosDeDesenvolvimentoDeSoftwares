package com.ru.automatizado.ruautomatizado.testes;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAlunos {

	static WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\andre\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/login");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		WebElement matricula = driver.findElement(By.id("matriculaa"));
		matricula.sendKeys("1000");
		WebElement senha = driver.findElement(By.id("senhaa"));
		senha.sendKeys("1000");
		
		WebElement botaoLogin = driver.findElement(By.id("acess"));
		botaoLogin.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.get("http://localhost:8080/gerenciar");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Início"));
		driver.findElement(By.id("Estudantesss")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Test
	public void cadastroAluno() {
		
		driver.get("http://localhost:8080/aluno");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Alunos"));
		
		driver.findElement(By.id("cadastroAluno")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.get("http://localhost:8080/aluno/cadastro");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Cadastro de Aluno"));
		
		WebElement matricula= driver.findElement(By.id("inputMatricula"));
		matricula.sendKeys("200");
		WebElement cpf= driver.findElement(By.id("inputCPF"));
		cpf.sendKeys("200");
		WebElement nome= driver.findElement(By.id("inputNome"));
		nome.sendKeys("And");
		WebElement botaoSalvar= driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		assertEquals("Operação Realizada Com Sucesso!", driver.findElement(By.id("mensagemSucesso")).getText());
		
		
		matricula= driver.findElement(By.id("inputMatricula"));
		matricula.sendKeys("200");
		cpf= driver.findElement(By.id("inputCPF"));
		cpf.sendKeys("200");
		botaoSalvar= driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		assertEquals("Por Favor Informe O Nome", driver.findElement(By.id("mensagemErro")).getText());
		
		WebElement botaoVoltar= driver.findElement(By.id("btnVoltar"));
		botaoVoltar.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.get("http://localhost:8080/aluno");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Alunos"));
		
		
	}
	
	@Test
	public void excluirAluno() {
		
		driver.get("http://localhost:8080/aluno");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Alunos"));
		
		WebElement botaoLixeira = driver.findElement(By.id("btnLixeira"));
		botaoLixeira.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		WebElement botaoVoltar = driver.findElement(By.id("btnCancelar"));
		botaoVoltar.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.get("http://localhost:8080/aluno");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Alunos"));
		
		botaoLixeira = driver.findElement(By.id("btnLixeira"));
		botaoLixeira.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		WebElement botaoExcluir = driver.findElement(By.id("btnExcluir"));
		botaoExcluir.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Alunos"));
	} 
	
	@Test
	public void pesquisarAluno() {

		driver.get("http://localhost:8080/aluno");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Alunos"));
		
		WebElement textPesquisa = driver.findElement(By.id("matricula"));
		textPesquisa.sendKeys("200");
		WebElement botaoPesquisa = driver.findElement(By.id("btnPesquisa"));
		botaoPesquisa.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		WebElement tabela = driver.findElement(By.id("tabela"));
		WebElement coluna = tabela.findElement(By.id("colMatricula"));
		assertEquals("200", coluna.getText());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.get("http://localhost:8080/aluno");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Alunos"));
		
		textPesquisa = driver.findElement(By.id("matricula"));
		textPesquisa.sendKeys("20055");
		botaoPesquisa = driver.findElement(By.id("btnPesquisa"));
		botaoPesquisa.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		assertEquals("Nenhum aluno foi encontrado", driver.findElement(By.id("mensagemPesquisa")).getText());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	@Test
	public void editarAluno() {
		
		driver.get("http://localhost:8080/aluno");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Alunos"));
		WebElement botaoPincel = driver.findElement(By.id("btnPincel"));
		botaoPincel.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.get("http://localhost:8080/aluno/200");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Cadastro de Aluno"));
		
		WebElement textCpf = driver.findElement(By.id("inputCPF"));
		textCpf.sendKeys("1000");
		WebElement textNome = driver.findElement(By.id("inputNome"));
		textNome.sendKeys("Anderson");
		WebElement btnSalvar = driver.findElement(By.id("btnSalvar"));
		btnSalvar.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		assertEquals("Operação Realizada Com Sucesso!", driver.findElement(By.id("mensagemSucesso")).getText());
		
		WebElement btnVoltar = driver.findElement(By.id("btnVoltar"));
		btnVoltar.click();
		
		driver.get("http://localhost:8080/aluno");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Alunos"));
		botaoPincel = driver.findElement(By.id("btnPincel"));
		botaoPincel.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.get("http://localhost:8080/aluno/200");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Cadastro de Aluno"));
		
		textNome = driver.findElement(By.id("inputNome"));
		textNome.clear();
		btnSalvar = driver.findElement(By.id("btnSalvar"));
		btnSalvar.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		assertEquals("Por Favor Informe O Nome", driver.findElement(By.id("mensagemErro")).getText());
		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}


}
