package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação de PageObjects.
 */
public abstract class BasePO {
    /**
     * Driver base que será utilizado pelas páginas.
     */
    protected WebDriver driver;


    /**
     * Construtor para criação da PageFactory.
     * @param driver Driver do navegador atual.
     **/
    protected BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
