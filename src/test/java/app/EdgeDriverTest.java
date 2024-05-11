package app;

import org.junit.BeforeClass;
import org.junit.Test;
import page.GooglePO;

import static org.junit.Assert.assertEquals;

public class EdgeDriverTest extends BaseTest {

    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes() {
        driver.get(GOOGLE_LINK);
        googlePage = new GooglePO(driver);
    }

    @Test
    public void deveFazerPesquisaNoGoogle() {
        googlePage.pesquisar("teste");
        String result = googlePage.obterAbaTodasNoResultadoDaPesquisa();
        assertEquals(result, "Todas", result);
    }

}