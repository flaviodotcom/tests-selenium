package app;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import page.ControleProdutoPO;
import page.LoginPO;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleProdutoTest extends BaseTest {


    private static LoginPO loginPage;
    private static ControleProdutoPO produtoPage;

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
        loginPage.efetuarLogin("admin@admin.com", "admin@123");
        produtoPage = new ControleProdutoPO(driver);
    }

    @Test
    public void t001_deveAbrirModalAoClicarNoBotao() {
        produtoPage.buttonAdicionar.click();
        produtoPage.buttonAdicionar.click();

        String titulo = produtoPage.tituloModal.getText();
        assertEquals("Produto", titulo);
    }

    @Test
    public void t002_deveVoltarParaPaginaDeLogin() {
        produtoPage.linkVoltar.click();

        String tituloPagina = loginPage.getTituloPagina();
        assertEquals("Login", tituloPagina);
    }
}
