package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    /**
     * document.querySelector('form.form-login>div.alert>span')
     **/
    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    /**
     * Construtor de BasePO.
     * @param driver Driver do navegador atual.
     **/
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public String getMensagem() {
        return this.spanMensagem.getText();
    }

    public void efetuarLogin(String email, String senha) {
        inputEmail.sendKeys(email);
        inputSenha.sendKeys(senha);
        buttonEntrar.click();
    }

}
