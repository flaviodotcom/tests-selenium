package app;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import page.ControleProdutoPO;
import page.LoginPO;

import static org.junit.Assert.*;
import static utils.AppUtils.dataAtual;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleProdutoTest extends BaseTest {
// TODO: Os botões de entrar e sair do modal precisam ser clicados duas vezes.

    private static LoginPO loginPage;
    private static ControleProdutoPO produtoPage;

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
        loginPage.efetuarLogin("admin@admin.com", "admin@123");
        produtoPage = new ControleProdutoPO(driver);
    }

    @Test
    public void t001_deveAbrirModalAoClicarNoBotao() {
        entrarModal();
        produtoPage.buttonAdicionar.click(); // refatorar refs @TODO
        String titulo = produtoPage.tituloModal.getText();

        assertEquals("Produto", titulo);
        sairModal();
        produtoPage.buttonSairModal.click(); // refatorar refs @TODO
    }

    @Test
    public void t002_naoDeveCadastrarProdutoSemPreencherTodosOsCampos() {
        entrarModal();
        produtoPage.buttonSalvarModal.click();
        String mensagemDeErro = produtoPage.mensagemErroModal.getText();

        assertTrue(mensagemDeErro, mensagemDeErro.contains("Todos os campos são obrigatórios"));
        sairModal();
    }

    @Test
    public void t003_deveCadastrarProdutoComTodosOsCamposPreenchidos() {
        entrarModal();
        entrarModal();
        this.cadastrarProduto("001", "Cubo mágico", 1, 19.99, dataAtual());

        // @TODO melhorar a lógica do teste.
        String mensagemDeErro = produtoPage.mensagemErroModal.getText();
        assertFalse(mensagemDeErro, mensagemDeErro.contains("Todos os campos são obrigatórios"));
        sairModal();
    }

    @Test
    public void t004_deveVoltarParaPaginaDeLogin() {
        produtoPage.linkVoltar.click();

        String tituloPagina = loginPage.getTituloPagina();
        assertEquals("Login", tituloPagina);
    }

    public void entrarModal() {
        produtoPage.buttonAdicionar.click();
    }

    public void sairModal() {
        produtoPage.buttonSairModal.click();
    }

    private void cadastrarProduto(String codigo, String nome, Integer quantidade, Double valor, String data) {
        escrever(produtoPage.codigoModal, codigo);
        escrever(produtoPage.nomeModal, nome);
        escrever(produtoPage.quantidadeModal, quantidade.toString());
        escrever(produtoPage.valorModal, valor.toString());
        escrever(produtoPage.dataModal, data);

        produtoPage.buttonSalvarModal.click();
    }

    /**
     * Escreve o valor desejado no campo de input.
     * @param input - campo de input do elemento web
     * @param valor - valor que será escrito no input
     **/
    private void escrever(WebElement input, String valor) {
        input.clear();
        input.sendKeys(valor, Keys.TAB);
    }

}
