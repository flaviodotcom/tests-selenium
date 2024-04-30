package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {

    @FindBy(id = "APjFqb")
    public WebElement inputPesquisa;
    @FindBy(id= "result-stats")
    public WebElement divResultadoPesquisa;

    /**
     * Construtor de BasePO.
     * @param driver Driver do navegador.
     **/
    public GooglePO(WebDriver driver) {
        super(driver);
    }
}
