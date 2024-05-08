package app;

import org.junit.BeforeClass;
import org.junit.Test;
import page.LoginPO;

import static org.junit.Assert.assertEquals;


public class LoginTest extends BaseTest {

    private static LoginPO loginPage;

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
    }

    @Test
    public void naoDeveLogarComCamposVazios() {
        loginPage.inputEmail.sendKeys("");
        loginPage.inputSenha.sendKeys("");
        loginPage.buttonEntrar.click();

        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }
}
