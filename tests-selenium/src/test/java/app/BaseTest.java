package app;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;

public abstract class BaseTest {
    protected static WebDriver driver;
    protected static final String GOOGLE_LINK = "https://www.google.com";
    private static final String PATH = "src/resources/msedgedriver.exe";
    private static final String PAGINA_LOGIN = "src/resources/templates/login.html";

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.edge.driver", PATH);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(paginaLogin());
    }

    @AfterClass
    public static void close() {
        driver.quit();
    }

    private static String paginaLogin() {
        return new File(PAGINA_LOGIN).getAbsolutePath();
    }

}
