package app;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverTest {
    private WebDriver driver;
    private final String PATH = "src/resources/msedgedriver.exe";
    private final String GOOGLE_LINK = "https://www.google.com";

    private void init() {
        System.setProperty("webdriver.edge.driver", PATH);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(GOOGLE_LINK);
        driver.quit();
    }

    @Test
    public void deve_abrir_o_google() {
        init();
    }

}