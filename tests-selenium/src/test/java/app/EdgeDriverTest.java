package app;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class EdgeDriverTest extends BaseTest {

    @Test
    public void deveFazerPesquisaNoGoogle() {
        WebElement inputGoogle = driver.findElement(By.id("APjFqb"));
        inputGoogle.sendKeys("teste" + Keys.ENTER);

        String result = driver.findElement(By.id("result-stats")).getText();
        assertTrue(result, result.contains("Aproximadamente"));
    }

}