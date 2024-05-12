package app;

import org.junit.BeforeClass;
import org.junit.Test;
import page.PJePO;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class PJeTest extends BaseTest {
    private static PJePO pjePage;

    @BeforeClass
    public static void prepararTestes() {
        driver.get("https://pje1g.trf1.jus.br/pje/login.seam");
        pjePage = new PJePO(driver);
    }

    @Test
    public void deveFalharAoTentarEfetuarLogin() {
        trocaDriverParaIframeDeLogin();
        pjePage.inputUsername.sendKeys("");
        pjePage.inputPassword.sendKeys("");
        pjePage.buttonEntrarLogin.click();

        String mensagem = pjePage.getMensagemDeErro();
        assertEquals(mensagem, "Nome de usuário ou senha inválida.");
    }

    public void trocaDriverParaIframeDeLogin() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().frame("ssoFrame");
    }

}
