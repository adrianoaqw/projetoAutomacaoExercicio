package br.com.everis.projetoAutomacao.page;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import static br.com.everis.projetoAutomacao.utils.Utils.*;

public class RealizarCompraPage {

	public RealizarCompraPage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this); // inicializar todos os elementos da web localizados pela anotação @FindBy
	}

	
	//Localizar elementos da pagina 
	
	@FindBy(linkText = "Sign in")
	private WebElement BUTTON_SINGIN;
	@FindBy(linkText = "Faded Short Sleeve T-shirts")
	private WebElement ITEM;
	@FindBy(linkText = "Proceed to checkout")
	private WebElement BUTTON_PROCEED_HECKOUT;

	@FindBy(id = "SubmitLogin")
	private WebElement BUTTON_SUBMIT_LOGIN;
	@FindBy(id = "email")
	private WebElement INPUT_EMAIL;
	@FindBy(id = "passwd")
	private WebElement INPUT_PASSWORD;
	@FindBy(id = "product_price_1_1_441145")
	private WebElement VALOR_UNIDADE;
	@FindBy(name = "quantity_1_1_0_441145")
	private WebElement QUANTIDADE_UNIDADE;
	@FindBy(id = "total_product_price_1_1_441145")
	private WebElement VALOR_TOTAL_QUANTIDADE_UNIDADE;
	@FindBy(id = "total_shipping")
	private WebElement VALOR_TAXA;
	@FindBy(id = "total_price")
	private WebElement VALOR_TOTAL_DA_COMPRA;
	@FindBy(id = "quantity_wanted")
	private WebElement BUTTON_QUANTIDADE_ITEM;

	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	private WebElement BUTTON_ADD_CART;

	// executar ações no elementos da pagina  
	
	public void homePage() throws WebDriverException {
		String url = "http://automationpractice.com/index.php";
		getDriver().get(url);
	}

	public void paginaLogin() throws WebDriverException {
		BUTTON_SINGIN.click();
	}

	public void realizarLogin(String email, String password) throws WebDriverException {

		INPUT_EMAIL.sendKeys(email);
		INPUT_PASSWORD.sendKeys(password);
		BUTTON_SUBMIT_LOGIN.click();
	}

	public void adicionarItem() throws WebDriverException {
		ITEM.click();
	}

	public void adicionarItemCarrinho() throws WebDriverException {
		BUTTON_QUANTIDADE_ITEM.clear();
		BUTTON_QUANTIDADE_ITEM.sendKeys("2");
		BUTTON_ADD_CART.click();
		BUTTON_PROCEED_HECKOUT.click();
	}

	public void valores() {

	}

	public Double validarValorDoItem() {
		Double valorUnidade = Double.parseDouble(VALOR_UNIDADE.getText().replace("$", ""));
		Integer quantidadeItem = Integer.parseInt(QUANTIDADE_UNIDADE.getAttribute("value"));
		Double valorTotalSemTaxa = Double.parseDouble(VALOR_TOTAL_QUANTIDADE_UNIDADE.getText().replace("$", ""));

		Double valorTotalSemTaxaItem = valorUnidade * quantidadeItem;
		assertEquals(valorTotalSemTaxa, valorTotalSemTaxaItem);

		return valorTotalSemTaxaItem;
	}

	public void valorTotalDoCarrinho() {
		Double taxa = Double.parseDouble(VALOR_TAXA.getText().replace("$", ""));
		Double valorTotaDoCarrinho = Double.parseDouble(VALOR_TOTAL_DA_COMPRA.getText().replace("$", ""));

		Double valorItem = validarValorDoItem();
		Double valorTotalDaCompra = taxa + valorItem;

		assertEquals(valorTotalDaCompra, valorTotaDoCarrinho);
	}

}
