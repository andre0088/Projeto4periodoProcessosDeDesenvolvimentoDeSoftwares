package com.ru.automatizado.ruautomatizado.testes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLog {

static WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\andre\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void testLoginAndLogout() {
		driver.get("http://localhost:8080/login");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Login"));
		WebElement matricula = driver.findElement(By.id("matriculaa"));
		matricula.sendKeys("admin");
		WebElement senha = driver.findElement(By.id("senhaa"));
		senha.sendKeys("admin");
		
		WebElement botaoLogin = driver.findElement(By.id("acess"));
		botaoLogin.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.get("http://localhost:8080/gerenciar");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Início"));
		
		driver.findElement(By.partialLinkText("Sair")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.get("http://localhost:8080/login");
		assertTrue("Página correta",driver.getTitle().contentEquals("RU Automatizado - Login"));
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		matricula = driver.findElement(By.id("matriculaa"));
		matricula.sendKeys("admin");
		senha = driver.findElement(By.id("senhaa"));
		senha.sendKeys("sasas");
		botaoLogin = driver.findElement(By.id("acess"));
		botaoLogin.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertEquals("Dados inválidos!",driver.findElement(By.id("alerta")).getText());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
