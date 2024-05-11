package app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.io.File;

public abstract class BaseTest {
    protected static WebDriver driver;
    protected static final String GOOGLE_LINK = "https://www.google.com";
    private static final String PAGINA_LOGIN = "src/resources/templates/login.html";
    private static final WebDriverManager wdm = WebDriverManager.edgedriver().browserInDocker()
            .dockerDefaultArgs("--disable-gpu,--no-sandbox")
            .browserVersion("latest");

    @BeforeClass
    public static void init() {
        driver = wdm.create();
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
