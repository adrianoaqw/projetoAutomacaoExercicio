package br.com.everis.projetoAutomacao.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)                //Runner instancia uma classe de testes e executar todos os seus respectivos métodos
@CucumberOptions(plugin = {"pretty"},
				features = "src/test/resources/features",
				glue = "br.com.everis.projetoAutomacao.stepsDefinitions",
				tags = {""},
				snippets = SnippetType.CAMELCASE,
				monochrome = true,
				dryRun = false
				
		)

public class Runner {

}

