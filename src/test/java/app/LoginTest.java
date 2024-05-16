package app;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import page.LoginPO;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // ordenar testes de forma ascendente
public class LoginTest extends BaseTest {

    private static LoginPO loginPage;

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
    }

    @Test
    public void t001_naoDeveLogarComCamposVazios() {
        loginPage.efetuarLogin("", "");

        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void t002_deveLogarNoSistema() {
        loginPage.efetuarLogin("admin@admin.com", "admin@123");

        String title = loginPage.getTituloPagina();
        assertEquals(title, "Controle de Produtos");
    }
}
