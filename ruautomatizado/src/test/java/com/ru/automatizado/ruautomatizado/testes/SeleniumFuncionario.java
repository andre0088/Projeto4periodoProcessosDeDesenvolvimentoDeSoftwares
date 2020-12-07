package com.ru.automatizado.ruautomatizado.testes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFuncionario {

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
		driver.findElement(By.id("funcionarios")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	@Test
	public void cadastroFuncionario() {
		driver.get("http://localhost:8080/funcionario");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Funcionários"));
		
		driver.findElement(By.id("cadastroFuncionario")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.get("http://localhost:8080/funcionario/cadastro");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Cadastro de Funcionário"));
		
		WebElement matricula= driver.findElement(By.id("inputMatricula"));
		matricula.sendKeys("1000");
		WebElement senha= driver.findElement(By.id("inputPassword3"));
		senha.sendKeys("1000");
		WebElement confirmaSenha= driver.findElement(By.id("inputPassword4"));
		confirmaSenha.sendKeys("1000");
		WebElement nome= driver.findElement(By.id("inputNome"));
		nome.sendKeys("Alexandre");
		
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
		matricula.sendKeys("7000");
		senha= driver.findElement(By.id("inputPassword3"));
		senha.sendKeys("7000");
		confirmaSenha= driver.findElement(By.id("inputPassword4"));
		confirmaSenha.sendKeys("7");
		nome= driver.findElement(By.id("inputNome"));
		nome.sendKeys("Thiago");
		botaoSalvar= driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		assertEquals("Confirme novamente sua senha", driver.findElement(By.id("mensagemErro")).getText());
		
		WebElement botaoVoltar= driver.findElement(By.id("btnVoltar"));
		botaoVoltar.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.get("http://localhost:8080/funcionario");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Funcionários"));
		
	}
	
	@Test
	public void excluirFuncionario() {
		driver.get("http://localhost:8080/funcionario");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Funcionários"));
		
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
		
		driver.get("http://localhost:8080/funcionario");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Funcionários"));
		
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
		
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Funcionários"));
	}
	
	@Test
	public void pesquisarFuncionario() {

		driver.get("http://localhost:8080/funcionario");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Funcionários"));
		
		WebElement textPesquisa = driver.findElement(By.id("matricula"));
		textPesquisa.sendKeys("1000");
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
		assertEquals("1000", coluna.getText());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.get("http://localhost:8080/funcionario");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Funcionários"));
		
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
		
		assertEquals("Nenhum funcionário foi encontrado", driver.findElement(By.id("mensagemPesquisa")).getText());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	@Test
	public void editarFuncionario() {
		
		driver.get("http://localhost:8080/funcionario");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Funcionários"));
		WebElement botaoPincel = driver.findElement(By.id("btnPincel"));
		botaoPincel.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.get("http://localhost:8080/funcionario/900");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Cadastro de Funcionário"));
		
		WebElement nome = driver.findElement(By.id("inputNome"));
		nome.clear();
		nome.sendKeys("Felipe");
		WebElement senha = driver.findElement(By.id("inputPassword3"));
		senha.sendKeys("900");
		WebElement confirmSenha = driver.findElement(By.id("inputPassword4"));
		confirmSenha.sendKeys("900");
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
		
		driver.get("http://localhost:8080/funcionario");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Funcionários"));
		botaoPincel = driver.findElement(By.id("btnPincel"));
		botaoPincel.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		driver.get("http://localhost:8080/funcionario/900");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Cadastro de Funcionário"));
		
		senha = driver.findElement(By.id("inputPassword3"));
		senha.sendKeys("900");
		confirmSenha = driver.findElement(By.id("inputPassword4"));
		confirmSenha.sendKeys("600");
		btnSalvar = driver.findElement(By.id("btnSalvar"));
		btnSalvar.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		assertEquals("Confirme novamente sua senha", driver.findElement(By.id("mensagemErro")).getText());
		
	}
	
	

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
