package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {

    @FindBy(id = "APjFqb")
    public WebElement inputPesquisa;
    @FindBy(xpath = "//*[@id=\"hdtb-sc\"]/div/div/div[1]/div/div[1]/span/div")
    public WebElement divTodas;

    /**
     * Construtor de BasePO.
     * @param driver Driver do navegador.
     **/
    public GooglePO(WebDriver driver) {
        super(driver);
    }


    /**
     * Método que efetua uma pesquisa no Google baseado no texto informado.
     * @param texto Texto a ser pesquisado.
     **/
    public void pesquisar(String texto) {
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }

    /**
     * Método que retorna o resultado da pesquisa.
     **/
    public String obterAbaTodasNoResultadoDaPesquisa() {
        return divTodas.getText();
    }
}
