package app;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public abstract class BaseTest {
    protected static WebDriver driver;
    private static final String PATH = "src/resources/msedgedriver.exe";
    private static final String GOOGLE_LINK = "https://www.google.com";

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.edge.driver", PATH);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(GOOGLE_LINK);
    }

    @AfterClass
    public static void close() {
        driver.quit();
    }
}
