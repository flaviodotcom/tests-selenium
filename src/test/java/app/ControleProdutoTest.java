package app;

import builder.ProdutoBuilder;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
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
        produtoPage.cadastrarProduto("001", "Cubo mágico", 1, 19.99, dataAtual());
        sairModal();

        assertFalse(produtoPage.trProdutoCadastrado.getText().isEmpty());
    }

    @Test
    public void t004_deveCadastrarProdutoPassandoAlgunsCamposComoPadrao() {
        entrarModal();
        ProdutoBuilder criarProduto = new ProdutoBuilder(produtoPage);
        criarProduto
                .addNome("Caneta")
                .addCodigo("002")
                .addValor(1.50)
                .builder();
        sairModal();

        assertTrue(produtoPage.trProdutoCadastrado.getText().contains("Caneta"));
    }

    @Test
    public void t005_naoDeveCadastrarProdutoPassandoValoresNulos() {
        entrarModal();
        ProdutoBuilder criarProduto = new ProdutoBuilder(produtoPage);
        criarProduto
                .addNome(null)
                .addCodigo("005")
                .addValor(10.65)
                .addData(null)
                .addQuantididade(null)
                .builder();

        String mensagemDeErro = produtoPage.mensagemErroModal.getText();
        assertTrue(mensagemDeErro, mensagemDeErro.contains("Todos os campos são obrigatórios"));

        sairModal();
    }

    @Test
    public void t100_deveVoltarParaPaginaDeLogin() {
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

}
