package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ControleProdutoPO extends BasePO {

    @FindBy(id = "btn-adicionar")
    public WebElement buttonAdicionar;

    @FindBy(css = "ul>li>a.nav-link")
    public WebElement linkVoltar;

    @FindBy(css = "div>h4.modal-title")
    public WebElement tituloModal;

    /**
     * Construtor de BasePO.
     * @param driver Driver do navegador atual.
     **/
    public ControleProdutoPO(WebDriver driver) {
        super(driver);
    }
}
