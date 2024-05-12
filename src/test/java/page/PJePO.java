package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PJePO extends BasePO {
    @FindBy(id = "username")
    public WebElement inputUsername;
    @FindBy(id = "password")
    public WebElement inputPassword;
    @FindBy(id = "kc-login")
    public WebElement buttonEntrarLogin;
    @FindBy(css = "div.text-danger>span.kc-feedback-text")
    public WebElement spanFalhaAoLogar;

    /**
     * Construtor de BasePO.
     * @param driver Driver do navegador atual.
     **/
    public PJePO(WebDriver driver) {
        super(driver);
    }

    public String getMensagemDeErro() {
        return this.spanFalhaAoLogar.getText();
    }
}
