package app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import page.GooglePO;

import static org.junit.Assert.assertTrue;

public class EdgeDriverTest extends BaseTest {

    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes() {
        googlePage = new GooglePO(driver);
    }

    @Test
    public void deveFazerPesquisaNoGoogle() {
        googlePage.inputPesquisa.sendKeys("teste" + Keys.ENTER);
        String result = googlePage.divResultadoPesquisa.getText();
        assertTrue(result, result.contains("Aproximadamente"));
    }

}