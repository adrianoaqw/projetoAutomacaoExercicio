package br.com.everis.projetoAutomacao.stepsDefinitions;

import br.com.everis.projetoAutomacao.page.RealizarCompraPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import static br.com.everis.projetoAutomacao.utils.Utils.*;

public class RealizarCompraSteps {
	//parâmetros determinados pelo cucumber 

	RealizarCompraPage realizarCompras = new RealizarCompraPage(getDriver());

	
	@Dado("que eu esteja na pagina de login")
	public void queEuEstejaNaPaginaDeLogin() {
		realizarCompras.paginaLogin();
	}

	@Dado("realize o login com o email {string} e senha {string}")
	public void realizeOLoginComOEmailESenha(String email, String password) {
		realizarCompras.paginaLogin();
		realizarCompras.realizarLogin(email, password);
	}

	@Dado("que eu tenha selecionado um item para o carrinho")
	public void queEuTenhaSelecionadoUmItemParaOCarrinho() {
		realizarCompras.homePage();
		realizarCompras.adicionarItem();
	}

	@Quando("eu clico no icone do carrinho")
	public void euClicoNoIconeDoCarrinho() {
		realizarCompras.adicionarItemCarrinho();
	}

	@Quando("verifico a quantidade de item e o valor unitario do produto")
	public void verificoAQuantidadeDeItemEOValorUnitarioDoProduto() {
		realizarCompras.validarValorDoItem();
	}


	@Então("o valor total apresentado no carrinho deve ser igual a soma dos produtos mais taxas")
	public void oValorTotalApresentadoNoCarrinhoDeveSerIgualASomaDosProdutosMaisTaxas() {
		realizarCompras.valorTotalDoCarrinho();
	}

}
