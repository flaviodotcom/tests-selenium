package page;

import org.openqa.selenium.Keys;
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

    @FindBy(id = "codigo")
    public WebElement codigoModal;

    @FindBy(id = "nome")
    public WebElement nomeModal;

    @FindBy(id = "quantidade")
    public WebElement quantidadeModal;

    @FindBy(id = "valor")
    public WebElement valorModal;

    @FindBy(id = "data")
    public WebElement dataModal;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvarModal;

    @FindBy(id = "btn-sair")
    public WebElement buttonSairModal;

    @FindBy(css = "div.modal-body>div.alert-danger>span")
    public WebElement mensagemErroModal;

    @FindBy(css = "table.table-hover>tbody")
    public WebElement trProdutoCadastrado;

    /**
     * Construtor de BasePO.
     * @param driver Driver do navegador atual.
     **/
    public ControleProdutoPO(WebDriver driver) {
        super(driver);
    }

    /**
     * Escreve o valor desejado no campo de input.
     * @param input - campo de input do elemento web
     * @param valor - valor que será escrito no input
     **/
    public void escrever(WebElement input, String valor) {
        input.clear();
        input.sendKeys(valor, Keys.TAB);
    }

    public void cadastrarProduto(String codigo, String nome, Integer quantidade, Double valor, String data) {
        escrever(codigoModal, codigo);
        escrever(nomeModal, nome);
        escrever(quantidadeModal, quantidade.toString());
        escrever(valorModal, valor.toString());
        escrever(dataModal, data);

        buttonSalvarModal.click();
    }

}
