package br.com.everis.projetoAutomacao.api;


import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.junit.Test;



public class ValidarRequest {
	
	 @Test
	    public void testDadoUmAdministradorQuandoCadastroViagemEntaoObtenhoStatusCode201(){


		 baseURI = "https://httpbin.org";
		 
		 				//conteudo que estão no request
		 				given()
						.contentType(ContentType.JSON)
						// Ação
						.when() 
						.get("/get")
						//resposta validável
					    .then()
					    //log da execução do teste
						.log().all()
						//Valida o código status da resposta
						.statusCode(200)
						//verificar se o valor específico corresponde a um esperado
						.assertThat ()
						//Valide se o corpo de resposta JSON está em conformidade
						.body("url", containsString("https://httpbin.org/get"));


	 }    
}
