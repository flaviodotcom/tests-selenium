package app;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertTrue;

public class EdgeDriverTest {
    private WebDriver driver;
    private final String PATH = "src/resources/msedgedriver.exe";
    private final String GOOGLE_LINK = "https://www.google.com";

    private void init() {
        System.setProperty("webdriver.edge.driver", PATH);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(GOOGLE_LINK);
    }

    @Test
    public void deveFazerPesquisaNoGoogle() {
        init();
        WebElement inputGoogle = driver.findElement(By.id("APjFqb"));
        inputGoogle.sendKeys("teste" + Keys.ENTER);

        String result = driver.findElement(By.id("result-stats")).getText();
        assertTrue(result, result.contains("Aproximadamente"));
    }

}