package br.com.everis.projetoAutomacao.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public  class Utils {
	public static ChromeDriver driver; //possibilita a comunicação do selenium com o Google Chrome
	
	public static void acessarSistema() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
	}
	
	public static WebDriver getDriver()
    {
        return driver;
    }

}
	

