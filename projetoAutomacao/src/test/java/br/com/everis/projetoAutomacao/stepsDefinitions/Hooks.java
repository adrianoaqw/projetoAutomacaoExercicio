package br.com.everis.projetoAutomacao.stepsDefinitions;

import static br.com.everis.projetoAutomacao.utils.Utils.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

//gatilho que vai te ajudar no começo e no fim de um cenário
	
	@Before()
	public void suiteSetUp() {
		acessarSistema();
	}
	@After
	public void suiteTearDown() {
		driver.quit();
	}
}
