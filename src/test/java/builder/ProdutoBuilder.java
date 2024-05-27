package builder;

import page.ControleProdutoPO;

import static utils.AppUtils.dataAtual;
import static utils.AppUtils.formatarString;

public class ProdutoBuilder {
    private String codigo = "0001";
    private String nome = "Cubo Mágico";
    private Integer quantidade = 1;
    private Double valor = 19.99;
    private String data = dataAtual();

    private final ControleProdutoPO produto;

    public ProdutoBuilder(ControleProdutoPO produto) {
        this.produto = produto;
    }


    public ProdutoBuilder addCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public ProdutoBuilder addNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ProdutoBuilder addQuantididade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public ProdutoBuilder addValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public ProdutoBuilder addData(String data) {
        this.data = data;
        return this;
    }

    /**
     * Utilizando o design pattern Builder para preencher os campos do produto a ser cadastrado.
     **/
    public void builder() {
        produto.escrever(produto.codigoModal, formatarString(codigo));
        produto.escrever(produto.nomeModal, formatarString(nome));
        produto.escrever(produto.quantidadeModal, formatarString(String.valueOf(quantidade)));
        produto.escrever(produto.valorModal, formatarString(String.valueOf(valor)));
        produto.escrever(produto.dataModal, formatarString(data));

        produto.buttonSalvarModal.click();
    }

}
